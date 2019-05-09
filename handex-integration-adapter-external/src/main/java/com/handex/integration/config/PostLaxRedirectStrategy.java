package com.handex.integration.config;

import org.apache.http.*;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class PostLaxRedirectStrategy extends LaxRedirectStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostLaxRedirectStrategy.class);

    public HttpUriRequest getRedirect(
            final HttpRequest request,
            final HttpResponse response,
            final HttpContext context) throws ProtocolException {
        URI uri = getLocationURI(request, response, context);
        String method = request.getRequestLine().getMethod();
        if (method.equalsIgnoreCase(HttpHead.METHOD_NAME)) {
            return new HttpHead(uri);
        } else if (method.equalsIgnoreCase(HttpPost.METHOD_NAME)) {

            final HttpPost post = new HttpPost(uri);
            LOGGER.info("Request instance of:" + request.getClass() );
            if (request instanceof HttpEntityEnclosingRequest)
            {
                    HttpEntity entity = ((HttpEntityEnclosingRequest) request).getEntity();
                post.setEntity(entity);
            }
            return post;
        } else if (method.equalsIgnoreCase(HttpGet.METHOD_NAME)) {
            return new HttpGet(uri);
        } else {
            throw new IllegalStateException("Redirect called on un-redirectable http method: " + method);
        }
    }
}
