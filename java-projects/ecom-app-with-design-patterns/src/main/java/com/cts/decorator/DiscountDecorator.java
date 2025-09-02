package com.cts.decorator;

public class DiscountDecorator extends ProductDecorator{

    private double discount;

    public DiscountDecorator(Product decoratedProduct, double discount) {
        super(decoratedProduct);
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice() * (1-(discount*0.01));
    }

    public String getDescription(){
        return decoratedProduct.getDescription() + "(Discount : )"+discount+"%";
    }
}
