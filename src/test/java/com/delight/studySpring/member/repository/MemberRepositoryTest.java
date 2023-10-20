package com.delight.studySpring.member.repository;

import com.delight.studySpring.member.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by delightPIP on 2023/10/20.
 */
@SpringBootTest
@Transactional //test 완료 후 rollback
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Rollback(value = false)
    void testMember() throws Exception {
        Member member = Member.builder()
                .user_id("test1")
                .user_pw("password")
                .name("김연습")
                .build();

        Long saveId = memberRepository.save(member);

        Member findMember = memberRepository.findById(saveId);

        findMember.changeName("김열공");

        entityManager.flush();
        entityManager.clear();

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getName()).isEqualTo(member.getName());
        assertThat(findMember).isEqualTo(member);
        assertThat(findMember.getUpdatedDate()).isAfter(findMember.getCreatedDate());
    }

}