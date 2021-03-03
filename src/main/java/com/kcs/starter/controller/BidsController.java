package com.kcs.starter.controller;

import java.util.HashMap;
import java.util.Map;

import com.kcs.starter.exceptions.BiddingClosedException;
import com.kcs.starter.exceptions.InvalidUserResourceInputException;
import com.kcs.starter.exceptions.ProductsNotFoundException;
import com.kcs.starter.model.Bids;
import com.kcs.starter.reponse.ValidResponse;
import com.kcs.starter.service.BidsService;
import com.kcs.starter.validator.EmailValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("v1/bids")
public class BidsController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BidsService bidsService;

    @PostMapping(value = "")
    public ResponseEntity<ValidResponse> bidProduct(@RequestBody Bids bids)
            throws InvalidUserResourceInputException, ProductsNotFoundException, BiddingClosedException {
        logger.info("/POST: bidProduct : bids={}", bids.toString());

        validateBidProduct(bids);

        ValidResponse validResponse = bidsService.addBid(bids);

        return new ResponseEntity<>(validResponse, HttpStatus.OK);
    }

    private void validateBidProduct(Bids bids) throws InvalidUserResourceInputException {
        Map<String, String> errorMap = new HashMap<String, String>();

        if (StringUtils.isEmpty(bids.getProductId())) {
            errorMap.put("ProductId", "Invalid");
        }

        if (StringUtils.isEmpty(bids.getBuyerEmail()) || !EmailValidator.validate(bids.getBuyerEmail())) {
            errorMap.put("Email", "Invalid");
        }

        if (bids.getBidPrice() == null) {
            errorMap.put("Price", "Invalid");
        }

        if (!errorMap.isEmpty()) {
            throw new InvalidUserResourceInputException(errorMap);
        }
    }
}
