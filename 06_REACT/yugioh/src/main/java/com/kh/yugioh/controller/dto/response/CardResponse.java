package com.kh.yugioh.controller.dto.response;

import lombok.Getter;

@Getter
public class CardResponse {

    private Long id;
    private String ownerLoginId;
    private String name;
    private String artwork;
    private String cardType;
    private int attack;
    private int defense;

    public CardResponse(Long id, String ownerLoginId, String name,
                        String artwork, String cardType, int attack, int defense) {
        this.id = id;
        this.ownerLoginId = ownerLoginId;
        this.name = name;
        this.artwork = artwork;
        this.cardType = cardType;
        this.attack = attack;
        this.defense = defense;
    }

}
