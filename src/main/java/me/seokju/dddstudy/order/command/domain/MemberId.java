package me.seokju.dddstudy.order.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class MemberId implements Serializable {
    @Column(name = "member_id")
    private String id;
}
