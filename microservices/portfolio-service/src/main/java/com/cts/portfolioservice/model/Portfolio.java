package com.cts.portfolioservice.model;

import java.util.List;

public class Portfolio {

    private long id;
    private String username;
    List<Stock> stocks;
    private double totalInvested;
    private double currentValue;
    private double profit;

}
