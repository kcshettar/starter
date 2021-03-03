package com.kcs.starter.exceptions;

import com.kcs.starter.exceptions.base.ApiException;
import com.kcs.starter.exceptions.base.ErrorCode;

import org.springframework.http.HttpStatus;

public class BiddingClosedException extends ApiException {
    private static final long serialVersionUID = 1L;

    public BiddingClosedException() {
        super("bidding is closed", HttpStatus.FORBIDDEN, ErrorCode.E_BID_CLOSED);
    }
}
