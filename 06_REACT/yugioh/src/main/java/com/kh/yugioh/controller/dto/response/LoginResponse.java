package com.kh.yugioh.controller.dto.response;

import lombok.Getter;

@Getter
public class LoginResponse {

    private Long id;
    private String loginId;
    private String nickname;

    public LoginResponse(Long id, String loginId, String nickname) {
        this.id = id;
        this.loginId = loginId;
        this.nickname = nickname;
    }
}
