package me.seokju.dddstudy.order.command.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChangeShippingService {

    private final OrderRepository orderRepository;

    @Transactional
    public void changeShipping(ChangeShippingRequest changeReq) {
        Optional<Order> orderOpt = orderRepository.findById(new OrderNo(changeReq.getNumber()));
        Order order = orderOpt.orElseThrow(NoOrderException::new);
        order.changeShippingInfo(changeReq.getShippingInfo());
    }
}
