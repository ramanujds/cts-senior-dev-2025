package com.cts.decorator;

public class SimpleProduct implements Product{

    private String name;
    private double price;

    public SimpleProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
