package me.seokju.dddstudy.common.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Address(
        @Column(name = "zip_code")
        String zipCode,

        @Column(name = "address1")
        String address1,

        @Column(name = "address2")
        String shippingAddress2
) {

}
