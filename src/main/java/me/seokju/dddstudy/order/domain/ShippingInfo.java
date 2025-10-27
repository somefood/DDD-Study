package me.seokju.dddstudy.order.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.seokju.dddstudy.common.model.Address;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ShippingInfo {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipcode", column = @Column(name = "shipping_zipcode")),
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2")),
    })
    private Address address;

    @Column(name = "shipping_message")
    private String message;

    @Embedded
    private Receiver receiver;

    public ShippingInfo(String receiverName, String receiverPhoneNumber, String shippingAddress1, String shippingAddress2, String shippingZipcode) {
        this.receiver = new Receiver(receiverName, receiverPhoneNumber);
        this.address = new Address(shippingZipcode, shippingAddress1, shippingAddress2);
    }
}
