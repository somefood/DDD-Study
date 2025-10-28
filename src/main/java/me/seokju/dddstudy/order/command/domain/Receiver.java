package me.seokju.dddstudy.order.command.domain;

import jakarta.persistence.Column;

public record Receiver(
        @Column(name = "receiver_name")
        String name,

        @Column(name = "receiver_phone")
        String phone) {
}