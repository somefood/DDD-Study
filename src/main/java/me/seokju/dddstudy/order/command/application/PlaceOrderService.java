package me.seokju.dddstudy.order.command.application;

import lombok.RequiredArgsConstructor;
import me.seokju.dddstudy.catalog.domain.product.Product;
import me.seokju.dddstudy.catalog.domain.product.ProductId;
import me.seokju.dddstudy.catalog.domain.product.ProductRepository;
import me.seokju.dddstudy.common.ValidationError;
import me.seokju.dddstudy.common.ValidationErrorException;
import me.seokju.dddstudy.order.command.domain.*;
import me.seokju.dddstudy.order.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlaceOrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @Transactional
    public OrderNo placeOrder(OrderRequest orderRequest) {
        List<ValidationError> errors = validateOrderRequest(orderRequest);
        if (!errors.isEmpty()) throw new ValidationErrorException(errors);

        List<OrderLine> orderLines = new ArrayList<>();
        for (OrderProduct op : orderRequest.getOrderProducts()) {
            Optional<Product> productOpt = productRepository.findById(new ProductId(op.getProductId()));
            Product product = productOpt.orElseThrow(() -> new NoOrderProductException(op.getProductId()));
            orderLines.add(new OrderLine(product.getId(), product.getPrice(), op.getQuantity()));
        }

        OrderNo orderNo = orderRepository.nextOrderNo();
        Orderer orderer = orderService.createOrderer(orderRequest.getOrdererMemberId());

        Order order = new Order(orderNo, orderer, orderLines, orderRequest.getShippingInfo(), OrderState.PAYMENT_WAITING);
        orderRepository.save(order);
        return orderNo;
    }

    private List<ValidationError> validateOrderRequest(OrderRequest orderRequest) {
        return new OrderRequestValidator().validate(orderRequest);
    }
}
