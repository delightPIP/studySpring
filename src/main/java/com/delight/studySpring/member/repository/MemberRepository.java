package com.delight.studySpring.member.repository;

import com.delight.studySpring.member.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager entityManager;

    public Long save(Member member) {
        entityManager.persist(member);
        return member.getId();
    }

    public List<Member> findMemberAll() {
        return entityManager.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return entityManager.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Member> findByUserId(String userId) {
        return entityManager.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public Long count(String userId) {
        return entityManager.createQuery("select count(m) from Member m where m.userId = :userId", Long.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    public Member findById(Long id) {
        return entityManager.find(Member.class, id);
    }

    public void removeMember(Long id) {
        Member member = findById(id);
        entityManager.remove(member);
    }
}
