package com.cts.portfolioservice.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
public class Portfolio {

    @Field("_id")
    @Id
    private ObjectId id;
    private String username;
    private List<Stock> stocks = new ArrayList<>();
    private double totalInvested;
    private double currentValue;
    private double profit;

}
