package me.seokju.dddstudy.order.domain;

import lombok.Getter;

@Getter
public class OrderLine {
    private Product product;

    private Money price;

    private int quantity;

    private Money amounts;

    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = new Money(price);
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
