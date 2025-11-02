package me.seokju.dddstudy.order.command.domain;

import lombok.Getter;
import me.seokju.dddstudy.common.event.Event;

@Getter
public class OrderCanceledEvent extends Event {
    private final String orderNumber;

    public OrderCanceledEvent(String number) {
        super();
        this.orderNumber = number;
    }
}
