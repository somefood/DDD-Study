package me.seokju.dddstudy.order.command.domain;

public interface OrderService {
    Orderer createOrderer(MemberId ordererMemberId);
}
