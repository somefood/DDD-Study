package me.seokju.dddstudy.order.query.dao;

import me.seokju.dddstudy.order.query.dto.OrderSummary;
import me.seokju.dddstudy.order.query.dto.OrderView;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderSummaryDao extends Repository<OrderSummary, String> {

    List<OrderSummary> findAll(Specification<OrderSummary> spec);

    List<OrderSummary> findByOrdererId(String ordererId, Sort sort);

    List<OrderSummary> findAll(Specification<OrderSummary> spec, Sort sort);

    @Query("""
                select new me.seokju.dddstudy.order.query.dto.OrderView(
                    o.number, o.state, m.name, m.id, p.name
                )
                from Order o join o.orderLines ol, Member m, Product p
                where o.orderer.memberId.id = :ordererId
                and o.orderer.memberId.id = m.id
                and index(ol) = 0
                and ol.productId.id = p.id
                order by o.number.number desc
            """)
    List<OrderView> findOrderView(String ordererId);
}
