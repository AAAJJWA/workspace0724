package com.kh.yugioh.service;

import com.kh.yugioh.controller.dto.request.CardRequest;
import com.kh.yugioh.controller.dto.response.CardResponse;
import com.kh.yugioh.entity.Card;
import com.kh.yugioh.mapper.CardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardMapper cardMapper;

    public CardServiceImpl(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    @Override
    public CardResponse create(CardRequest req) {

        Card card = new Card();
        card.setOwnerLoginId(req.getOwnerLoginId());
        card.setTemplate(req.getYugiohTemplate());
        card.setElement(req.getYugiohElement());
        card.setName(req.getName());
        card.setArtwork(req.getArtwork());
        card.setLevel(req.getYugiohLevel());
        card.setEffect(req.getYugiohEffect());
        card.setEdition(req.getYugiohEdition());
        card.setCardNumber(req.getYugiohCardNumber());
        card.setCardType(req.getYugiohCardType());
        card.setAttack(req.getYugiohAttack());
        card.setDefense(req.getYugiohDefense());
        card.setIdentifier(req.getYugiohIdentifier());
        card.setCopyright(req.getYugiohCopyright());

        cardMapper.save(card);

        return new CardResponse(
                card.getId(),
                card.getOwnerLoginId(),
                card.getName(),
                card.getArtwork(),
                card.getCardType(),
                card.getAttack(),
                card.getDefense()
        );
    }

    @Override
    public List<CardResponse> findAll() {
        return cardMapper.findAll().stream()
                .map(c -> new CardResponse(
                        c.getId(),
                        c.getOwnerLoginId(),
                        c.getName(),
                        c.getArtwork(),
                        c.getCardType(),
                        c.getAttack(),
                        c.getDefense()
                ))
                .toList();
    }

    @Override
    public List<CardResponse> findMyCards(String ownerLoginId) {
        return cardMapper.findOwner(ownerLoginId).stream()
                .map(c -> new CardResponse(
                        c.getId(),
                        c.getOwnerLoginId(),
                        c.getName(),
                        c.getArtwork(),
                        c.getCardType(),
                        c.getAttack(),
                        c.getDefense()
                ))
                .toList();
    }

    @Override
    public void delete(Long id) {
        cardMapper.deleteId(id);
    }
}
