package me.seokju.dddstudy.order.infra;

import lombok.RequiredArgsConstructor;
import me.seokju.dddstudy.order.command.application.RefundService;
import me.seokju.dddstudy.order.command.domain.OrderCanceledEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Service
public class OrderCanceledEventHandler {

    private final RefundService refundService;

    @Async
    @TransactionalEventListener(
            classes = OrderCanceledEvent.class,
            phase = TransactionPhase.AFTER_COMMIT
    )
    public void handle(OrderCanceledEvent event) {
        refundService.refund(event.getOrderNumber());
    }
}
