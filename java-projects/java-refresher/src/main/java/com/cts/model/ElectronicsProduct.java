package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ElectronicsProduct extends Product {

    String name;
    String brand;

    public ElectronicsProduct(double price, String category, String name, String brand) {
        super(price, category);
        this.name = name;
        this.brand = brand;
    }


}
