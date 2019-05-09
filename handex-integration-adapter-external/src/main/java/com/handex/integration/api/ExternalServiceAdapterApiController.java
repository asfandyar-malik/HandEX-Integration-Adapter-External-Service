package com.handex.integration.api;

import com.handex.integration.model.*;
import com.handex.integration.service.ExternalServiceClientService;
import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.handex.integration.common.UrlValues.*;

/**
 * Brex API controller.
 *
 * Please find an overview of all REST resources here: https://dashboard.brex.io/active-docs#/
 */
@RestController
@CacheControl(policy = CachePolicy.NO_CACHE)
public class ExternalServiceAdapterApiController {

    @Autowired
    ExternalServiceClientService externalServiceClientService;

    // POST /brex/api/v1//company/search/name
    @RequestMapping(
            value = BREX_API_BASE_URL + BREX_API_COMPANY_SEARCH_URL,
            method = RequestMethod.POST,
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public List<ExternalServiceResult> findByCountryAndRecordName(@RequestBody ExternalServiceRequestCriteria externalServiceRequestCriteria) {
        return externalServiceClientService.findByCountryAndRecordName(externalServiceRequestCriteria);
    }

}
