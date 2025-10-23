package me.seokju.dddstudy.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class OrderNo implements Serializable {

    @Column(name = "order_number")
    private String number;
}
