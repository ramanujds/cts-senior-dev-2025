package com.cts.portfolioservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.util.List;

@Data
public class Portfolio {

    @Field("_id")
    @Id
    private BigInteger id;
    private String username;
    private List<Stock> stocks;
    private double totalInvested;
    private double currentValue;
    private double profit;

}
