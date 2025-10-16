package me.seokju.dddstudy.order.domain;

import lombok.Getter;

@Getter
public class OrderLine {
    private Product product;

    private int price;

    private int quantity;

    private int amounts;

    public OrderLine(Product product, int price, int quantity, int amounts) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = amounts;
    }

    private int calculateAmounts() {
        return price * quantity;
    }
}
