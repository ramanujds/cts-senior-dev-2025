package com.cts.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {

    private Map<String, Integer> inventory = new HashMap<>();
    private List<InventoryObserver> observers = new ArrayList<>();

    public void addObserver(InventoryObserver observer){
        observers.add(observer);
    }

    public  void removeObserver(InventoryObserver observer){
        observers.remove(observer);
    }

    public void setInventory(String productId, int quantity){
        inventory.put(productId,quantity);
        notifyObservers(productId,quantity);
    }

    void notifyObservers(String productId, int quantity) {
        observers.forEach(
                o -> o.update(productId, quantity)
        );
    }

}
