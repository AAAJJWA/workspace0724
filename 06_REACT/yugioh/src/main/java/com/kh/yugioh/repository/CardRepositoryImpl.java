package com.kh.yugioh.repository;

import com.kh.yugioh.entity.Card;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Card card) {
        em.persist(card);
    }

    @Override
    public List<Card> findAll() {
        return em.createQuery(
                "select c from Card c",
                Card.class
        ).getResultList();
    }

    @Override
    public List<Card> findByMemberId(Long memberId) {
        return em.createQuery(
                        "select c from Card c join c.member m where m.id = :memberId",
                        Card.class
                )
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Override
    public Optional<Card> findById(Long id) {
        return Optional.ofNullable(em.find(Card.class, id));
    }

    @Override
    public void delete(Card card) {
        em.remove(card);
    }
}
