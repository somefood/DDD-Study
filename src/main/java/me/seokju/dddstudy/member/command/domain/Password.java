package me.seokju.dddstudy.member.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Password(
        @Column(name = "password")
        String value
) {
    public boolean match(String password) {
        return this.value.equals(password);
    }
}
