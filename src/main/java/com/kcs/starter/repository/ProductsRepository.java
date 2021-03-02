package com.kcs.starter.repository;

import com.kcs.starter.model.Products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductsRepository extends CrudRepository<Products, String> {

}
