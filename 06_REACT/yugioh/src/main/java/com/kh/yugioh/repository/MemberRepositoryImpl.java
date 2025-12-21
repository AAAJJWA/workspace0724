package com.kh.yugioh.repository;

import com.kh.yugioh.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public boolean existsByLoginId(String loginId) {
        Long count = em.createQuery(
                        "select count(m) from Member m where m.loginId = :loginId",
                        Long.class
                ).setParameter("loginId", loginId)
                .getSingleResult();

        return count > 0;
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return em.createQuery(
                        "select m from Member m where m.loginId = :loginId",
                        Member.class
                ).setParameter("loginId", loginId)
                .getResultStream()
                .findFirst();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(em.find(Member.class, id));
    }

}
