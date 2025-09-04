package com.cts.productapp.api;



import com.cts.productapp.model.Product;
import com.cts.productapp.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {

    private ProductRepository productRepo;

    public ProductApi(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }



    @GetMapping
    public List<Product> getAllProducts(){
        return productRepo.getAllProducts();
    }




}
