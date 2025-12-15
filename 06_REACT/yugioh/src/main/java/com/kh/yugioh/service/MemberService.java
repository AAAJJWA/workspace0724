package com.kh.yugioh.Service;

import com.kh.yugioh.controller.dto.request.LoginRequest;
import com.kh.yugioh.controller.dto.request.MemberRequest;
import com.kh.yugioh.controller.dto.response.LoginResponse;
import com.kh.yugioh.controller.dto.response.MemberResponse;

public interface MemberService {

    MemberResponse register(MemberRequest memberRequest);

    LoginResponse login(LoginRequest loginRequest);
}