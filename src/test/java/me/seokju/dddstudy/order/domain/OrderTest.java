package me.seokju.dddstudy.order.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void create() {
        // Arrange
        Orderer orderer = new Orderer();
        List<OrderLine> orderLines = List.of(new OrderLine(new ProductId(), 1000, 5));
        ShippingInfo shippingInfo = new ShippingInfo("receiver1", "010-1234-5678", "address1", "addressDetail1", "12345");

        // Act
        Order order = new Order(orderer, orderLines, shippingInfo);

        // Assert
        assertThat(order.getOrderLines()).hasSizeGreaterThanOrEqualTo(1);
        assertThat(order.getShippingInfo()).isNotNull();
    }
}
