package com.kh.yugioh.service;

import com.kh.yugioh.controller.dto.request.CardRequest;
import com.kh.yugioh.controller.dto.response.CardResponse;
import com.kh.yugioh.entity.Card;
import com.kh.yugioh.entity.Member;
import com.kh.yugioh.repository.CardRepository;
import com.kh.yugioh.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final MemberRepository memberRepository;

    public CardServiceImpl(CardRepository cardRepository,
                           MemberRepository memberRepository) {
        this.cardRepository = cardRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public CardResponse create(CardRequest request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        Card card = new Card(
                member,
                request.getYugiohTemplate(),
                request.getYugiohElement(),
                request.getName(),
                request.getArtwork(),
                request.getYugiohLevel(),
                request.getYugiohEffect(),
                request.getYugiohEdition(),
                request.getYugiohCardNumber(),
                request.getYugiohCardType(),
                request.getYugiohAttack(),
                request.getYugiohDefense(),
                request.getYugiohIdentifier(),
                request.getYugiohCopyright()
        );

        cardRepository.save(card);
        return CardResponse.from(card);
    }

    @Override
    public List<CardResponse> findAll() {
        return cardRepository.findAll().stream()
                .map(CardResponse::from)
                .toList();
    }

    @Override
    public List<CardResponse> findMyCards(String loginId) {
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        return cardRepository.findByMemberId(member.getId()).stream()
                .map(CardResponse::from)
                .toList();
    }

    @Override
    public CardResponse findById(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("카드를 찾을 수 없습니다."));
        return CardResponse.from(card);
    }


    @Override
    public void delete(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("카드가 존재하지 않습니다."));
        cardRepository.delete(card);
    }
}

