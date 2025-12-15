package com.kh.yugioh.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {

    private Long id;

    private String ownerLoginId;   // 카드 소유자 (로그인 아이디)
    private String template;       // yugiohTemplate
    private String element;        // yugiohElement
    private String name;
    private String artwork;        // 이미지 URL or Base64
    private int level;
    private String effect;
    private String edition;
    private String cardNumber;
    private String cardType;
    private int attack;
    private int defense;
    private String identifier;
    private String copyright;

    // 생성자
    public Card() {}

}