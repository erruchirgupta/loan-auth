package com.ms.loan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class LoanAuthWebServiceConfig {

	@Value("${webservices.default.url:https://loan-auth.free.beeceptor.com/}") 
    private String url;
    
    @Value("${webservices.client-secret:oE8dG3uE8fL6nW1yO3rJ6xP5gD1fD4mM7eP0lO7wC0nS5pD0mT}")
    private String clientSecret;
    
    @Value("${webservices.client-id:c2c360c6-591f-495f-b45f-736df6bfe53e}")
    private String clientId;
    
    @Value("${webservices.auth:Basic ZXNidGVzdDpkY2JsQDEyMw==}")
    private String auth;
    
}
