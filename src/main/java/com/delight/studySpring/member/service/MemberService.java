package com.delight.studySpring.member.service;

import com.delight.studySpring.member.entity.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Service
@Transactional(readOnly = true) // JPA 의 데이터 변경은 트랜잭션 안에서 적용해야 지연로딩을 동작시킬 수 있다
public interface MemberService {

    Long join(Member member);

    @Transactional
    void updateName(Long id, String newName);

    @Transactional
    void updateUserPw(Long id, String userPw);

    List<Member> findMembers();

    Member findOne(Long id);

    List<Member> findOne(String userId);

    @Transactional
    void delete(Long id);
}
