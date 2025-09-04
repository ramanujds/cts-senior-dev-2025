package com.cts.productappreactive.repository;


import com.cts.productappreactive.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ProductRepositoryImpl extends ReactiveCrudRepository<Product,Integer> {

}
