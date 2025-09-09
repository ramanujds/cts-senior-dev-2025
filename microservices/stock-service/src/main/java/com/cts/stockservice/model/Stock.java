package com.cts.stockservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Data
public class Stock {

    @Id
    @Field(name = "_id")
    private BigInteger id;
    private String name;
    private String companyName;
    private double price;

}
