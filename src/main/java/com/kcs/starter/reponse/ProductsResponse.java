package com.kcs.starter.reponse;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kcs.starter.model.Products;

import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "timeStamp", "message", "productInfo", "productsInfo" })
public class ProductsResponse {
    private Instant timeStamp;
    private Products productInfo;
    private List<Products> productsInfo;

    public ProductsResponse(Products productInfo, List<Products> productsInfo) {
        this.timeStamp = Instant.now();
        this.productInfo = productInfo;
        this.productsInfo = productsInfo;
    }
}
