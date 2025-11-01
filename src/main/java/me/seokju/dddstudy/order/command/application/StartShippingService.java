package me.seokju.dddstudy.order.command.application;

import lombok.RequiredArgsConstructor;
import me.seokju.dddstudy.common.VersionConflictException;
import me.seokju.dddstudy.order.command.domain.NoOrderException;
import me.seokju.dddstudy.order.command.domain.Order;
import me.seokju.dddstudy.order.command.domain.OrderNo;
import me.seokju.dddstudy.order.command.domain.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StartShippingService {
    private final OrderRepository orderRepository;

    @Transactional
    public void startShipping(StartShippingRequest req) {
        Optional<Order> orderOpt = orderRepository.findById(new OrderNo(req.getOrderNumber()));
        Order order = orderOpt.orElseThrow(NoOrderException::new);
        if (order.matchingVersion(req.getVersion())) {
            throw new VersionConflictException();
        }
        order.startShipping();
    }
}
