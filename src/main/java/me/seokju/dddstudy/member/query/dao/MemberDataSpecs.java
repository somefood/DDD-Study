package me.seokju.dddstudy.member.query.dao;

import org.springframework.data.jpa.domain.Specification;

public class MemberDataSpecs {

    public static Specification<MemberData> nonBlocked() {
        return (root, query, cb)
                -> cb.equal(root.get(MemberData_.blocked), false);
    }

    public static Specification<MemberData> nameLike(String keyword) {
        return (root, query, cb)
                -> cb.like(root.get(MemberData_.name), keyword + "%");
    }
}
