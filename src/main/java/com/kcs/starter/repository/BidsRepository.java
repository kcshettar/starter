package com.kcs.starter.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import com.kcs.starter.model.Bids;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BidsRepository extends CrudRepository<Bids, String> {

    Optional<Bids> findByProductIdAndBuyerEmail(String productId, String buyerEmail);
}
