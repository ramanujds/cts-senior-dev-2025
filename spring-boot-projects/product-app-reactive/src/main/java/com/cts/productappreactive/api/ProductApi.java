package com.cts.productappreactive.api;

import com.cts.productappreactive.model.Product;
import com.cts.productappreactive.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {

    @Autowired
    private ProductRepositoryImpl productRepository;



    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable int id){
        return productRepository.findById(id);
    }

    @GetMapping
    public Flux<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping
    public Mono<Product> addProduct(@RequestBody Mono<Product> product){
        return product.flatMap(productRepository::save);
    }



}
