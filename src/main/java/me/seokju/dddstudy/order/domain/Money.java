package me.seokju.dddstudy.order.domain;

public record Money(int value) {

    public Money add(Money money) {
        return new Money(this.value + money.value);
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }

    public Integer getValue() {
        return this.value;
    }
}
