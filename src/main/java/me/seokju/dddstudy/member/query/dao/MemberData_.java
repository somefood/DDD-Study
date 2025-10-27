package me.seokju.dddstudy.member.query.dao;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MemberData.class)
public class MemberData_ {
    public static volatile SingularAttribute<MemberData, String> id;
    public static volatile SingularAttribute<MemberData, String> name;
    public static volatile SingularAttribute<MemberData, Boolean> blocked;
}
