package me.seokju.dddstudy.order.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record OrderNo(
        @Column(name = "order_number")
        String number
) implements Serializable {
}
