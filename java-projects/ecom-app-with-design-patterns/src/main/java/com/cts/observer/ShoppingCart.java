package com.cts.observer;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements InventoryObserver{

    private Map<String, Integer> cartItems = new HashMap<>();

    public void update(String productId, int quantity) {
        if (cartItems.containsKey(productId) && quantity == 0){
            System.out.println("Removing out-of-stock product: "+productId+" from cart");
            cartItems.remove(productId);
        }else{
            System.out.println("Inventory updated for Product ID : "+productId+" : "+quantity);
        }
    }

    public void addItem(String productId, int quantity){
        cartItems.put(productId,quantity);
    }
}
