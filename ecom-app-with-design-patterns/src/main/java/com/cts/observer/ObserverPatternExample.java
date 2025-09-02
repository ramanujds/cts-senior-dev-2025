package com.cts.observer;

public class ObserverPatternExample {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryService();

        ShoppingCart cart = new ShoppingCart();

        inventoryService.addObserver(cart);

        cart.addItem("iphone 17",10);

        inventoryService.setInventory("iphone 17",0);

    }

}
