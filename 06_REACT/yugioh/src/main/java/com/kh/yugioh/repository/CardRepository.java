package com.kh.yugioh.repository;

import com.kh.yugioh.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardRepository {

    void save(Card card);

    List<Card> findAll();

    List<Card> findByMemberId(Long memberId);

    Optional<Card> findById(Long id);

    void delete(Card card);
}
