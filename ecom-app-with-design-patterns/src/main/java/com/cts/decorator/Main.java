package com.cts.decorator;

public class Main {
    public static void main(String[] args) {

        Product product = new SimpleProduct("iPhone",70000);
        printProduct(product);

        Product discountedProduct = new DiscountDecorator(product,10);
        printProduct(discountedProduct);


    }

    static void printProduct(Product product){
        System.out.println(product.getDescription()+ " - ₹"+product.getPrice());
    }

}
