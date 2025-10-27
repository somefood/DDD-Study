package me.seokju.dddstudy.order.query.dao;

import me.seokju.dddstudy.order.query.dto.OrderSummary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql("classpath:shop-init-test.sql")
class OrderSummaryDaoTest {

    @Autowired
    private OrderSummaryDao orderSummaryDao;

    @Test
    void findAllSpec() {
        LocalDateTime from = LocalDateTime.of(2025, 1, 1, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2025, 1, 2, 0, 0, 0);

        Specification<OrderSummary> spec = OrderSummarySpecs.ordererId("user1")
                .and(OrderSummarySpecs.orderDateBetween(from, to));

        List<OrderSummary> results = orderSummaryDao.findAll(spec);
        assertThat(results).hasSize(1);
    }
}