package com.kcs.starter.exceptions.handler;

import com.kcs.starter.exceptions.base.ApiException;
import com.kcs.starter.exceptions.base.ErrorCode;
import com.kcs.starter.reponse.ErrorResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex) {
        logger.error("ExceptionHandlerController : handleApiException");
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode(), ex.getExtendedMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        logger.error("ExceptionHandlerController : handleException");
        ErrorResponse errorResponse = new ErrorResponse("Please contact developer.", ErrorCode.E_SERVER_ERROR, null);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
