package com.kcs.starter.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Null;

import com.kcs.starter.exceptions.InvalidUserResourceInputException;
import com.kcs.starter.exceptions.ProductsNotFoundException;
import com.kcs.starter.exceptions.base.ApiException;
import com.kcs.starter.model.Products;
import com.kcs.starter.reponse.ProductsResponse;
import com.kcs.starter.reponse.ValidResponse;
import com.kcs.starter.service.ProductsService;
import com.kcs.starter.validator.EmailValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("v1/products")
public class ProductsController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductsService productService;

    @PostMapping(value = "")
    public ResponseEntity<ValidResponse> addProduct(@RequestBody Products products)
            throws InvalidUserResourceInputException {
        logger.info("/POST: addProduct : products={}", products.toString());

        validateAddProduct(products);

        ValidResponse validResponse = productService.addProduct(products);

        return new ResponseEntity<>(validResponse, HttpStatus.OK);
    }

    private void validateAddProduct(Products products) throws InvalidUserResourceInputException {
        Map<String, String> errorMap = new HashMap<String, String>();
        if (StringUtils.isEmpty(products.getName())) {
            errorMap.put("name", "Invalid");
        }

        if (StringUtils.isEmpty(products.getDetails())) {
            errorMap.put("details", "Invalid");
        }

        if (StringUtils.isEmpty(products.getEmail()) || !EmailValidator.validate(products.getEmail())) {
            errorMap.put("name", "Invalid");
        }

        if (products.getPrice() == null) {
            errorMap.put("price", "Invalid");
        }

        if (products.getBiddingLastDate() == null) {
            errorMap.put("biddingLastDate", "Invalid");
        }

        if (!errorMap.isEmpty()) {
            throw new InvalidUserResourceInputException(errorMap);
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<ProductsResponse> getProducts() throws ProductsNotFoundException {
        logger.info("/GET: getProducts");

        ProductsResponse productsResponse = productService.getProducts();

        return new ResponseEntity<>(productsResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductsResponse> getProducts(@PathVariable("id") String productId)
            throws ProductsNotFoundException {
        logger.info("/GET: getProducts : productId={}", productId);

        ProductsResponse productsResponse = productService.getProducts(productId);

        return new ResponseEntity<>(productsResponse, HttpStatus.OK);
    }
}
