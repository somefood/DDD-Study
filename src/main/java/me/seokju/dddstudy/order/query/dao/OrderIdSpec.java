package me.seokju.dddstudy.order.query.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import me.seokju.dddstudy.order.query.dto.OrderSummary;
import me.seokju.dddstudy.order.query.dto.OrderSummary_;
import org.springframework.data.jpa.domain.Specification;

public class OrderIdSpec implements Specification<OrderSummary> {

    private String ordererId;

    public OrderIdSpec(String ordererId) {
        this.ordererId = ordererId;
    }

    @Override
    public Predicate toPredicate(Root<OrderSummary> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder cb) {
        return cb.equal(root.get(OrderSummary_.ordererId), ordererId);
    }
}
