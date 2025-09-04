package com.cts.productapp.service;

import com.cts.productapp.exception.RecordNotFoundException;
import com.cts.productapp.model.Product;
import com.cts.productapp.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    ProductRepository productRepo;

    @InjectMocks
    ProductService service;

    @Test
    void getProductById() {

        // Given
        int id = 1;
        Product product = new Product();
        product.setId(id);
        product.setName("iPhone");
        product.setPrice(10000);
        product.setDescription("Apple iPhone");

        // When
        Mockito.when(productRepo.findById(id)).thenReturn(Optional.of(product));

        Assertions.assertEquals(product,service.getProductById(id));

        // Verify
        Mockito.verify(productRepo,Mockito.times(1)).findById(id);

    }

    @Test
    void getProductByIdWhenProductIsNotPresent() {

        // Given
        int id = 1;

        // When
        Mockito.when(productRepo.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(RecordNotFoundException.class,()->service.getProductById(id));

        // Verify
        Mockito.verify(productRepo,Mockito.times(1)).findById(id);

    }




}