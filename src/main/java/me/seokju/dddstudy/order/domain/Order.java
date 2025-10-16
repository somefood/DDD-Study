package me.seokju.dddstudy.order.domain;

import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private Money totalAmounts;

    public Order(List<OrderLine> orderLines) {
        setOrderLines(orderLines);
    }

    public void changeShipped() {}

    public void changeShippingInfo() {}

    public void cancel() {}

    public void completePayment() {}

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
                .mapToInt(OrderLine::getAmounts)
                .sum();
        this.totalAmounts = new Money(sum);
    }
}
