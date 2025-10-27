package me.seokju.dddstudy.member.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record MemberId(
        @Column(name = "member_id")
        String id
) implements Serializable {

    public static MemberId of(String id) {
        return new MemberId(id);
    }
}
