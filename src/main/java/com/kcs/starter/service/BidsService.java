package com.kcs.starter.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.kcs.starter.exceptions.ProductsNotFoundException;
import com.kcs.starter.exceptions.BiddingClosedException;
import com.kcs.starter.model.Bids;
import com.kcs.starter.model.Products;
import com.kcs.starter.reponse.ValidResponse;
import com.kcs.starter.repository.BidsRepository;
import com.kcs.starter.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidsService {

    @Autowired
    BidsRepository bidsRepository;

    @Autowired
    ProductsRepository productsRepository;

    public ValidResponse addBid(Bids bids) throws ProductsNotFoundException, BiddingClosedException {
        Map<String, String> additionalInfo = new HashMap<String, String>();

        // check if prduct is available for bidding
        Optional<Products> product = productsRepository.findById(bids.getProductId());

        if (!product.isPresent()) {
            throw new ProductsNotFoundException();
        }

        // throw exception if bidding is closed
        LocalDateTime biddingLastDate = LocalDateTime.parse(product.get().getBiddingLastDate().toString());
        LocalDateTime localDateTime = LocalDateTime.now();
        if (biddingLastDate.isBefore(localDateTime)) {
            throw new BiddingClosedException();
        }

        // add/update bids
        String bidId;
        Optional<Bids> bid = bidsRepository.findByProductIdAndBuyerEmail(bids.getProductId(), bids.getBuyerEmail());
        if (bid.isPresent()) {
            bid.get().setBidPrice(bids.getBidPrice());
            bid.get().setBidTime(LocalDateTime.now());
            bidId = bidsRepository.save(bid.get()).getId();
        } else {
            bidId = bidsRepository.save(bids).getId();
        }

        additionalInfo.put("BidId", bidId);

        ValidResponse validResponse = new ValidResponse("bid posted", additionalInfo);
        return validResponse;
    }
}
