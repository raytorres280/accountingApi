package com.tekcard.app;

import org.springframework.web.client.RestTemplate;

public class ProductApiClient {

    RestTemplate restTemplate;

    public ProductApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public GetProductsResponse getProducts() {
        return this.restTemplate.getForObject("https://dummyjson.com/products", GetProductsResponse.class);
    }
}