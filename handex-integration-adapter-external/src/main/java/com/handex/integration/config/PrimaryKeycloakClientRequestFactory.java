package com.handex.integration.config;

import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrimaryKeycloakClientRequestFactory extends KeycloakClientRequestFactory {
}
