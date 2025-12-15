package com.kh.yugioh.controller.dto.request;

import lombok.Getter;

@Getter
public class MemberRequest {

    private String loginId;
    private String password;
    private String nickname;
}
