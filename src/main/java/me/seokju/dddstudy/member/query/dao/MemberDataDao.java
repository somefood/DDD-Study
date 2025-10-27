package me.seokju.dddstudy.member.query.dao;

import me.seokju.dddstudy.common.jpa.Rangeable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberDataDao extends Repository<MemberData, String> {

    Page<MemberData> findByBlocked(boolean blocked, Pageable pageable);

    List<MemberData> findByNameLike(String name, Pageable pageable); // 반환타입이 List이면 count 쿼리를 실행하지 않음

    List<MemberData> findAll(Specification<MemberData> spec, Pageable pageable);

    List<MemberData> findFirst3ByNameLikeOrderByName(String name);

    Optional<MemberData> findFirstByNameLikeOrderByName(String name);

    MemberData findFirstByBlockedOrderById(boolean blocked);

    List<MemberData> getRange(Specification<MemberData> spec, Rangeable rangeable);
}
