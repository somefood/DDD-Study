package me.seokju.dddstudy.order.infra.paygate;

import me.seokju.dddstudy.order.command.application.RefundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExternalRefundService implements RefundService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void refund(String orderNumber) {
        logger.info("refund order[{}]", orderNumber);
    }
}
