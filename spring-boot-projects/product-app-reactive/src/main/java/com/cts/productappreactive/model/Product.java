package com.cts.productappreactive.model;



import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Product {

    @Id
    private int id;
    private String name;
    private String description;
    private double price;



}
