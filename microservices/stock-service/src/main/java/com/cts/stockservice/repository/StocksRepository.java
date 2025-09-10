package com.cts.stockservice.repository;

import com.cts.stockservice.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface StocksRepository extends MongoRepository<Stock, BigInteger> {

    Optional<Stock> findByNameIgnoreCase(String name);

    List<Stock> findByNameContainingIgnoreCase(String name);

    List<Stock> findByNameInIgnoreCase(List<String> list);
}
