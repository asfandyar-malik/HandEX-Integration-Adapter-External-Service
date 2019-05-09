package com.handex.integration.service;

import com.handex.integration.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

import static com.handex.integration.common.UrlValues.*;


@Service
public class ExternalServiceClientServiceImpl implements ExternalServiceClientService {

    @Autowired
    private RestTemplate template;

    @NotNull
    @Value("${handex-integration-adapter-brex.service.brex.url}")
    private String endpoint;

    @NotNull
    @Value("${handex-integration-adapter-brex.service.brex.user_key}")
    private String userKey;

    @Override
    public List<ExternalServiceResult> findByCountryAndRecordName(ExternalServiceRequestCriteria externalServiceRequestCriteria) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("user_key", userKey);
        headers.set("content-type", "application/json; charset=utf-8");

        HttpEntity entity = new HttpEntity(headers);

//      ResponseEntity<ExternalServiceResult> response = template.getForEntity(endpoint.concat(BREX_API_BASE_URL).concat(BREX_API_COMPANY_SEARCH_URL), ExternalServiceResult.class, externalServiceRequestCriteria.getCountry(), externalServiceRequestCriteria.getName());
        ResponseEntity<ExternalServiceResult[]> response = template.exchange(endpoint + API_BASE_URL + BREX_API_COMPANY_SEARCH_URL + "/" + externalServiceRequestCriteria.getCountry() + "/" + externalServiceRequestCriteria.getName(), HttpMethod.GET, entity, ExternalServiceResult[].class);
        return Arrays.asList(response.getBody());
    }
}
