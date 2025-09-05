package com.cts.productappreactive.model;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;


@Data
public class Product {

    @Id
    @Field("_id")
    private BigInteger id;
    private String name;
    private String description;
    private double price;



}
