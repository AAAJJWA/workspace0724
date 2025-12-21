package com.kh.yugioh.repository;

import com.kh.yugioh.entity.Member;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    boolean existsByLoginId(String loginId);

    Optional<Member> findByLoginId(String loginId);

    Optional<Member> findById(Long id); // ✅ 추가 (핵심)
}

