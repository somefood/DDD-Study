package me.seokju.dddstudy.member.command.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    void block() {
        Member member = new Member(
                MemberId.of("member-1"),
                "name"
        );

        member.block();

        assertThat(member.isBlocked()).isTrue();
    }
}