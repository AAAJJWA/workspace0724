package com.kh.yugioh.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Card {

    private Long id;

    private String ownerLoginId;
    private String template;
    private String element;
    private String name;
    private String artwork;
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