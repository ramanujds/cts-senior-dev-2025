package com.cts.productappreactive.api;

import com.cts.productappreactive.model.Product;
import com.cts.productappreactive.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.Duration;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {

    @Autowired
    private ProductRepository productRepository;



    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable int id){
        return productRepository.findById(id);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getAllProducts(){
        return productRepository.findAll().delayElements(Duration.ofMillis(100));
    }

    @PostMapping
    public Mono<Product> addProduct(@RequestBody Mono<Product> product){
        return product.flatMap(productRepository::save);
    }



}
