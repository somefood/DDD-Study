package me.seokju.dddstudy.order.domain;

import lombok.Getter;

public record Address(String shippingAddress1, String shippingAddress2, String shippingZipcode) {
}
