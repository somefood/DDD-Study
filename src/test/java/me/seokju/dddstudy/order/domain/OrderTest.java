package me.seokju.dddstudy.order.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void 최소_한_종류_이상의_상품을_주문해야_한다() {
        // Arrange
        List<OrderLine> orderLines = List.of(new OrderLine(new Product(), 1000, 5));

        // Act
        Order order = new Order(orderLines);

        // Assert
        assertThat(order.getOrderLines()).hasSizeGreaterThanOrEqualTo(1);
    }
}