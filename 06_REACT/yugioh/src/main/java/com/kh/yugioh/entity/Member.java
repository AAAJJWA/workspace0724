package com.kh.yugioh.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long id;
    private String loginId;
    private String password;
    private String nickname;

    public Member() {
    }

    public Member(String loginId, String password, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
    }

    public Member(Long id, String loginId, String password, String nickname) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
    }
}