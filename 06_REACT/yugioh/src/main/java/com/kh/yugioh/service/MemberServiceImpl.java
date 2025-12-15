package com.kh.yugioh.service;

import com.kh.yugioh.mapper.MemberMapper;
import com.kh.yugioh.controller.dto.request.LoginRequest;
import com.kh.yugioh.controller.dto.request.MemberRequest;
import com.kh.yugioh.controller.dto.response.LoginResponse;
import com.kh.yugioh.controller.dto.response.MemberResponse;
import com.kh.yugioh.entity.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements com.kh.yugioh.Service.MemberService {

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public MemberResponse register(MemberRequest memberRequest) {

        if (memberMapper.existsLoginId(memberRequest.getLoginId())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        Member member = new Member(
                memberRequest.getLoginId(),
                memberRequest.getPassword(),
                memberRequest.getNickname()
        );

        memberMapper.save(member);

        return new MemberResponse(
                member.getId(),
                member.getLoginId(),
                member.getNickname()
        );
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        Member member = memberMapper.findLoginId(loginRequest.getLoginId());

        if (member == null) {
            throw new IllegalArgumentException("존재하지 않는 아이디입니다.");
        }

        if (!member.getPassword().equals(loginRequest.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponse(
                member.getId(),
                member.getLoginId(),
                member.getNickname()
        );
    }

}
