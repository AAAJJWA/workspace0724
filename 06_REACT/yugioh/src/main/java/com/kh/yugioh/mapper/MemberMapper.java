package com.kh.yugioh.mapper;

import com.kh.yugioh.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface MemberMapper {

    boolean existsLoginId(@Param("loginId") String loginId);

    void save(Member member);

    Member findLoginId(@Param("loginId") String loginId);
}
