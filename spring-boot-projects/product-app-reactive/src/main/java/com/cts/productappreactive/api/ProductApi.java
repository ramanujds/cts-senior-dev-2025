package com.cts.productappreactive.api;

import com.cts.productappreactive.exception.ResourceNotFoundException;
import com.cts.productappreactive.model.Product;
import com.cts.productappreactive.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.math.BigInteger;
import java.time.Duration;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {

    @Autowired
    private ProductRepository productRepository;



    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable BigInteger id){
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Product with ID "+id+" Not Found")))
                ;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getAllProducts(){
        return productRepository.findAll().delayElements(Duration.ofMillis(1000));
    }

    @PostMapping
    public Mono<Product> addProduct(@RequestBody Mono<Product> product){
        return product.flatMap(productRepository::save);
    }

    @GetMapping("/search")
    public Flux<Product> search(@RequestParam("name") String name){
        if(name!=null) return productRepository.findByNameContainingIgnoreCase(name)
                .switchIfEmpty(Flux.error(new ResourceNotFoundException("No product found with name "+name)))
                ;

        return productRepository.findAll();
    }

    @GetMapping("/search/price")
    public Flux<Product> search(@RequestParam("min") double min, @RequestParam("max") double max){
       if (min!=0 && max!=0)
            return productRepository.findByPriceBetween(min,max);
        return productRepository.findAll();
    }


}
