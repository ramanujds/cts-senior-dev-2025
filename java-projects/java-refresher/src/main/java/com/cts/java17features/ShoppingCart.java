package com.cts.java17features;



import com.cts.model.ClothingProduct;
import com.cts.model.ElectronicsProduct;
import com.cts.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList = new ArrayList<>();

    Product applyDiscounts(Product product){
       return switch (product){
           case ElectronicsProduct e when e.getPrice() >= 20000 -> {
               e.setPrice(e.getPrice()*(1.0-0.1));
               yield e;
           }
           case ClothingProduct c when c.getPrice() > 1000 -> {
               c.setPrice(c.getPrice()*(1.0-0.2));
               yield c;
           }
           default -> product;
       };
    }

    public void addToCart(Product product){

        if(product instanceof ElectronicsProduct e){
            System.out.println("Electronic " +e.getCategory());
        } else if(product instanceof ClothingProduct e){
            System.out.println("Clothing " +e.getCategory());
        }

        productList.add(product);



    }
}
