package com.kh.yugioh.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String template;

    @Column(nullable = false)
    private String element;

    @Column(nullable = false)
    private String name;

    @Lob
    private String artwork;

    private int level;

    @Lob
    private String effect;

    private String edition;
    private String cardNumber;
    private String cardType;
    private int attack;
    private int defense;

    @Column(nullable = false)
    private String identifier;

    private String copyright;

    public Card(
            Member member,
            String template,
            String element,
            String name,
            String artwork,
            int level,
            String effect,
            String edition,
            String cardNumber,
            String cardType,
            int attack,
            int defense,
            String identifier,
            String copyright
    ) {
        this.member = member;
        this.template = template;
        this.element = element;
        this.name = name;
        this.artwork = artwork;
        this.level = level;
        this.effect = effect;
        this.edition = edition;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.attack = attack;
        this.defense = defense;
        this.identifier = identifier;
        this.copyright = copyright;
    }
}
