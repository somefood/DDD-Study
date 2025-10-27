package me.seokju.dddstudy.member.command.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.seokju.dddstudy.common.jpa.EmailSetConverter;
import me.seokju.dddstudy.common.model.EmailSet;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class Member {

    @EmbeddedId
    private MemberId id;

    private String name;

    @Embedded
    private Password password;

    private boolean blocked;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emails;

    public Member(MemberId id, String name) {
        this.id = id;
        this.name = name;
    }

    public void block() {
        this.blocked = true;
    }
}
