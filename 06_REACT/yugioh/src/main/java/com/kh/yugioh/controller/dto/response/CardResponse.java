package com.kh.yugioh.controller.dto.response;

import com.kh.yugioh.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardResponse {

    private Long id;
    private Long memberId;
    private String memberNickname;
    private String name;
    private String artwork;
    private String cardType;
    private int attack;
    private int defense;

    public static CardResponse from(Card card) {
        return new CardResponse(
            card.getId(),
            card.getMember().getId(),
            card.getMember().getNickname(),
            card.getName(),
            card.getArtwork(),
            card.getCardType(),
            card.getAttack(),
            card.getDefense()
        );
    }
}
