package com.handex.integration.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RedirectOnPostKeycloakClientRequestFactory extends KeycloakClientRequestFactory {

    public RedirectOnPostKeycloakClientRequestFactory() {
        final HttpClient httpClient = HttpClients.custom()
                .disableCookieManagement()
                .setRedirectStrategy(new PostLaxRedirectStrategy())
                .build();
        super.setHttpClient(httpClient);
    }
}
