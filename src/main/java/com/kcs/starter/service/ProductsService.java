package com.kcs.starter.service;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.kcs.starter.exceptions.ProductsNotFoundException;
import com.kcs.starter.model.Products;
import com.kcs.starter.reponse.ProductsResponse;
import com.kcs.starter.reponse.ValidResponse;
import com.kcs.starter.repository.ProductsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductsRepository productRepository;

    public ValidResponse addProduct(Products products) {
        Map<String, String> additionalInfo = new HashMap<String, String>();
        additionalInfo.put("productId", products.getId());

        productRepository.save(products);

        ValidResponse validResponse = new ValidResponse("product posted", additionalInfo);
        return validResponse;
    }

    public ProductsResponse getProducts(String productId) throws ProductsNotFoundException {
        Optional<Products> products = productRepository.findById(productId);

        if (!products.isPresent()) {
            throw new ProductsNotFoundException();
        } else {
            return new ProductsResponse(products.get(), null);
        }
    }

    public ProductsResponse getProducts() throws ProductsNotFoundException {
        Iterable<Products> products = productRepository.findAll();

        List<Products> productsList = new LinkedList<>();
        products.forEach(x -> productsList.add(x));

        if (productsList.size() == 0) {
            throw new ProductsNotFoundException();
        } else {
            return new ProductsResponse(null, productsList);
        }
    }

    @Scheduled(cron = "${updateSchedule : 0 0/1 * * * * }", zone = "${updateScheduleZone:UTC}")
    public void updateBiddingStat() {
        Iterable<Products> products = productRepository.findAll();

        // List<Products> productsList = new LinkedList<>();
        for (Products product : products) {
            LocalDateTime biddingLastDate = product.getBiddingLastDate();
            LocalDateTime localDateTime = LocalDateTime.now();
            if (product.isSellStatus() == false && biddingLastDate.isBefore(localDateTime)) {
                product.setSellStatus(true);
            }
        }

        productRepository.saveAll(products);
    }
}
