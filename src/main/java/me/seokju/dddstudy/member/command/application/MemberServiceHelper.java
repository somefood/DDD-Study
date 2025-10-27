package me.seokju.dddstudy.member.command.application;

import me.seokju.dddstudy.member.command.domain.Member;
import me.seokju.dddstudy.member.command.domain.MemberId;
import me.seokju.dddstudy.member.command.domain.MemberRepository;

public class MemberServiceHelper {
    public static Member findExisitingMember(MemberRepository repository, String memberId) {
        return repository.findById(new MemberId(memberId))
                .orElseThrow(NoMemberException::new);
    }
}
