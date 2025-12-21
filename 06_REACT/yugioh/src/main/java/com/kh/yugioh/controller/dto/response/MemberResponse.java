package com.kh.yugioh.controller.dto.response;

import lombok.Getter;

@Getter
public class MemberResponse {

    private final Long id;
    private final String loginId;
    private final String nickname;

    public MemberResponse(Long id, String loginId, String nickname) {
        this.id = id;
        this.loginId = loginId;
        this.nickname = nickname;
    }
}
