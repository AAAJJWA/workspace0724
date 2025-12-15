package com.kh.yugioh.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardRequest {

    private String ownerLoginId;

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
