package com.cts.productapp.api;

import com.cts.productapp.exception.RecordNotFoundException;
import com.cts.productapp.model.Product;
import com.cts.productapp.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductApi.class)
@ExtendWith(SpringExtension.class)
class ProductApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService mockService;

    @Test
    void getProductById() throws Exception {

        // Given
        int id = 1;
        Product product = new Product();
        product.setId(id);
        product.setName("iPhone");
        product.setPrice(10000);
        product.setDescription("Apple iPhone");

        // When
        Mockito.when(mockService.getProductById(id)).thenReturn(product);

        mockMvc.perform(get("/api/v1/products/" + id))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "id": 1,
                          "name": "iPhone",
                          "description": "Apple iPhone",
                          "price":  10000
                        }
                        """));


    }

    @Test
    void getProductByIdWhenProductNotPresent() throws Exception {

        // Given
        int id = 1;

        // When
        Mockito.when(mockService.getProductById(id)).thenThrow(new RecordNotFoundException("..."));

        mockMvc.perform(get("/api/v1/products/" + id))
                .andExpect(status().isNotFound());


    }


}