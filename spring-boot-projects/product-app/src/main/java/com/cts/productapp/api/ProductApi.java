package com.cts.productapp.api;

import com.cts.productapp.model.Product;
import com.cts.productapp.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {

    private ProductRepository productRepo;

    public ProductApi(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productRepo.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

}
