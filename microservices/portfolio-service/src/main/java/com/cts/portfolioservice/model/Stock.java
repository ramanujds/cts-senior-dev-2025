package com.cts.portfolioservice.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Stock {
    private String name;
    private double buyingPrice;
    private int quantity;

}
