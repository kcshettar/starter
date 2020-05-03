package com.kcs.starter.reponse;

import java.time.Instant;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "timeStamp", "message", "additionalInfo" })
public class ValidResponse {

    private Instant timeStamp;
    private String message;
    private Map<String, String> additionalInfo;

    public ValidResponse(String message) {
        this.timeStamp = Instant.now();
        this.message = message;
    }

    public ValidResponse(String message, Map<String, String> additionalInfo) {
        this(message);
        this.additionalInfo = additionalInfo;
    }
}
