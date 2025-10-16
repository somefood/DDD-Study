package me.seokju.dddstudy.order.domain;

import lombok.Getter;

@Getter
public class ShippingInfo {
    private Receiver receiver;
    private Address address;

    public ShippingInfo(String receiverName, String receiverPhoneNumber, String shippingAddress1, String shippingAddress2, String shippingZipcode) {
        this.receiver = new Receiver(receiverName, receiverPhoneNumber);
        this.address = new Address(shippingAddress1, shippingAddress2, shippingZipcode);
    }
}
