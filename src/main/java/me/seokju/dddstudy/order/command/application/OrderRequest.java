package me.seokju.dddstudy.order.command.application;

import me.seokju.dddstudy.order.domain.MemberId;
import me.seokju.dddstudy.order.domain.ShippingInfo;

import java.util.List;

public class OrderRequest {

    private List<OrderProduct> orderProducts;

    private MemberId ordererMemberId;

    private ShippingInfo shippingInfo;

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public MemberId getOrdererMemberId() {
        return ordererMemberId;
    }

    public void setOrdererMemberId(MemberId ordererMemberId) {
        this.ordererMemberId = ordererMemberId;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }
}
