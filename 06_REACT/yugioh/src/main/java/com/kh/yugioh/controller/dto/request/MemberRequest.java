package com.kh.yugioh.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequest {

    private String loginId;
    private String password;
    private String nickname;
}
