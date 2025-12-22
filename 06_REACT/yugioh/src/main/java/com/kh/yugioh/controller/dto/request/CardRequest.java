package com.kh.yugioh.controller.dto.request;

import lombok.Getter;

@Getter
public class CardRequest {

    private Long memberId;

    private String yugiohTemplate;
    private String yugiohElement;
    private String name;
    private String artwork;
    private int yugiohLevel;
    private String yugiohEffect;
    private String yugiohEdition;
    private String yugiohCardNumber;
    private String yugiohCardType;
    private int yugiohAttack;
    private int yugiohDefense;
    private String yugiohIdentifier;
    private String yugiohCopyright;
}
