package com.example.relativity.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AzureFunctionClient {
    private final RestTemplate restTemplate;

    @Value("${azure.function.url}")
    private String functionUrl;

    public AzureFunctionClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<?> callFunction(Object request) {
        HttpEntity<Object> requestEntity = new HttpEntity<>(request);
        return restTemplate.exchange(functionUrl, HttpMethod.POST, requestEntity, String.class);
    }
}
