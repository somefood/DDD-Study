package me.seokju.dddstudy.member.command.application;

import lombok.RequiredArgsConstructor;
import me.seokju.dddstudy.member.command.domain.MemberId;
import me.seokju.dddstudy.member.command.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BlockMemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void block(String memberId) {
        var member = MemberServiceHelper.findExisitingMember(memberRepository, memberId);

        member.block();
    }
}
