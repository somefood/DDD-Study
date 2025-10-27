package me.seokju.dddstudy.order.query.dao;

import me.seokju.dddstudy.order.query.dto.OrderSummary;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderSummaryDao extends Repository<OrderSummary, String> {

    List<OrderSummary> findAll(Specification<OrderSummary> spec);
}
