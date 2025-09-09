package com.cts.stockservice.repository;

import com.cts.stockservice.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface StocksRepository extends MongoRepository<Stock, BigInteger> {

    Optional<Stock> findByNameIgnoreCase(String name);

    List<Stock> findByNameContainingIgnoreCase(String name);

}
