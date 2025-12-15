package com.kh.yugioh.controller;

import com.kh.yugioh.Service.MemberService;
import com.kh.yugioh.controller.dto.request.LoginRequest;
import com.kh.yugioh.controller.dto.request.MemberRequest;
import com.kh.yugioh.controller.dto.response.LoginResponse;
import com.kh.yugioh.controller.dto.response.MemberResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/members")
    public ResponseEntity<MemberResponse> register(
            @RequestBody MemberRequest memberRequest
    ) {
        MemberResponse memberResponse = memberService.register(memberRequest);

        return new ResponseEntity<>(memberResponse, HttpStatus.CREATED);
    }

    @PostMapping("/api/members/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest
    ) {
        LoginResponse loginResponse = memberService.login(loginRequest);

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

}
