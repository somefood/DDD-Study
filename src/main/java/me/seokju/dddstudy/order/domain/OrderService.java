package me.seokju.dddstudy.order.domain;

public interface OrderService {
    Orderer createOrderer(MemberId ordererMemberId);
}
