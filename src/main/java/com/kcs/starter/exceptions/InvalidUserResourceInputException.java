package com.kcs.starter.exceptions;

import java.util.Map;

import com.kcs.starter.exceptions.base.ApiException;
import com.kcs.starter.exceptions.base.ErrorCode;

import org.springframework.http.HttpStatus;

public class InvalidUserResourceInputException extends ApiException {

    private static final long serialVersionUID = 1L;

    public InvalidUserResourceInputException() {
        super("Invalid User Request", HttpStatus.BAD_REQUEST, ErrorCode.E_INVALID_USER_RESOURCE);
    }

    public InvalidUserResourceInputException(Exception ex) {
        super("Invalid User Request", HttpStatus.BAD_REQUEST, ErrorCode.E_INVALID_USER_RESOURCE, ex);
    }

    public InvalidUserResourceInputException(Map<String, String> extendedMessage) {
        super("Invalid User Request", HttpStatus.BAD_REQUEST, ErrorCode.E_INVALID_USER_RESOURCE);
        this.extendedMessage = extendedMessage;
    }
}
