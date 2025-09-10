package com.cts.stockservice.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Data
public class Stock {

    @Id
    @Field(name = "_id")
    private ObjectId id;
    private String name;
    private String companyName;
    private double price;

}
