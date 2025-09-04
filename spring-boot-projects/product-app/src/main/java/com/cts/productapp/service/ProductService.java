package com.cts.productapp.service;

import com.cts.productapp.exception.RecordNotFoundException;
import com.cts.productapp.model.Product;
import com.cts.productapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product getProductById(int id){
        return productRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("Product with id "+id+ " not found")
        );
    }

}
