package com.kcs.starter.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kcs.starter.exceptions.base.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "timeStamp", "message", "errorCode", "extendedMessage" })
public class ErrorResponse {

    private Instant timeStamp;

    @Setter
    private String message;

    @Setter
    private ErrorCode errorCode;

    @Setter
    private Map<String, String> extendedMessage;

    public ErrorResponse(String message, ErrorCode errorCode, Map<String, String> extendedMessage) {
        this.timeStamp = Instant.now();
        this.message = message;
        this.errorCode = errorCode;
        this.extendedMessage = extendedMessage;
    }
}
