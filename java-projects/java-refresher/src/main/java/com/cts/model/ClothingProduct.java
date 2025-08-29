package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClothingProduct extends  Product{

    String name;
    String size;

    public ClothingProduct(double price, String category, String size, String name) {
        super(price, category);
        this.size = size;
        this.name = name;
    }


}
