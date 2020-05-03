package com.kcs.starter.exceptions.base;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiException extends Exception {

    private static final long serialVersionUID = 1L;

    private HttpStatus httpStatus;
    private ErrorCode errorCode;

    @Setter
    protected Map<String, String> extendedMessage;

    public ApiException(String message, HttpStatus httpStatus, ErrorCode errorCode) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public ApiException(String message, HttpStatus httpStatus, ErrorCode errorCode, Throwable e) {
        super(message, e);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }
}
