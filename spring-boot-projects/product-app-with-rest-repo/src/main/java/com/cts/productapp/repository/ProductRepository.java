package com.cts.productapp.repository;

import com.cts.productapp.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, BigInteger> {

    List<Product> findByNameContainingIgnoreCase(String name);



}
