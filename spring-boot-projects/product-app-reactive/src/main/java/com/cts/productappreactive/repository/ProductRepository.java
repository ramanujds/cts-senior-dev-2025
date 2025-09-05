package com.cts.productappreactive.repository;


import com.cts.productappreactive.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.concurrent.Future;


public interface ProductRepository extends ReactiveMongoRepository<Product, BigInteger> {

    Flux<Product> findByNameContainingIgnoreCase(String name);

    Flux<Product> findByPriceBetween(double min, double max);

}
