package me.seokju.dddstudy.order.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CancelOrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void cancel(OrderNo orderNo, Canceller canceller) {
        Order order = orderRepository.findById(orderNo)
                .orElseThrow(() -> new NoOrderException());

        if (!cancelPolicy.hasCencellationPermission(order, canceller)) {
            throw new NoCancellablePermission();
        }
        order.cancel();
    }
}
