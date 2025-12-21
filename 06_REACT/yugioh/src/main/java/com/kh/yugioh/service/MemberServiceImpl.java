package com.kh.yugioh.service;

import com.kh.yugioh.controller.dto.request.LoginRequest;
import com.kh.yugioh.controller.dto.request.MemberRequest;
import com.kh.yugioh.controller.dto.response.LoginResponse;
import com.kh.yugioh.controller.dto.response.MemberResponse;
import com.kh.yugioh.entity.Member;
import com.kh.yugioh.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberResponse register(MemberRequest req) {

        if (memberRepository.existsByLoginId(req.getLoginId())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        Member member = new Member(
                req.getLoginId(),
                req.getPassword(),
                req.getNickname()
        );

        memberRepository.save(member);

        return new MemberResponse(
                member.getId(),
                member.getLoginId(),
                member.getNickname()
        );
    }

    @Override
    public LoginResponse login(LoginRequest req) {

        Member member = memberRepository.findByLoginId(req.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        if (!member.getPassword().equals(req.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponse(
                member.getId(),
                member.getLoginId(),
                member.getNickname()
        );
    }
}
