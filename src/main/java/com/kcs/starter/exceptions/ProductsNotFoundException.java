package com.kcs.starter.exceptions;

import com.kcs.starter.exceptions.base.ApiException;
import com.kcs.starter.exceptions.base.ErrorCode;

import org.springframework.http.HttpStatus;

public class ProductsNotFoundException extends ApiException {

    private static final long serialVersionUID = 1L;

    public ProductsNotFoundException() {
        super("products not found", HttpStatus.NOT_FOUND, ErrorCode.E_NOT_FOUND);
    }
}
