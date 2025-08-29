package com.cts.java17features;


import com.cts.model.ClothingProduct;
import com.cts.model.ElectronicsProduct;
import com.cts.model.Product;

public class PatternMatchingShoppingCart {

    public static void main(String[] args) {

       ShoppingCart shoppingCart = new ShoppingCart();
        Product p1 = new ElectronicsProduct(60000,"Smartphone","iPhone 15","Apple");
        Product p2 = new ClothingProduct(2000,"Shirt","Large","Arrow");
       shoppingCart.addToCart(p1);
       shoppingCart.addToCart(p2);

        System.out.println(shoppingCart.applyDiscounts(p2).getPrice());

    }


}
