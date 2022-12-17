package com.tekcard.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tekcard.entities.Product;

public class GetProductsResponse {

    @JsonProperty
    public Product[] products;
}
