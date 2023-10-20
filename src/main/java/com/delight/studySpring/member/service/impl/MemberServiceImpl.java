package com.delight.studySpring.member.service.impl;

import com.delight.studySpring.member.entity.Member;
import com.delight.studySpring.member.repository.MemberRepository;
import com.delight.studySpring.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Long count = memberRepository.count(member.getUser_id());
        if(count > 0) {
            throw new IllegalStateException("이미 존재하는 아이디 입니다.");
        }
    }

    @Override
    public void updateName(Long id, String newName) {
        Member member = memberRepository.findById(id);
        member.changeName(newName);
    }

    @Override
    public void updateUserPw(Long id, String newUserPw) {
        Member member = memberRepository.findById(id);
        member.changeUserPw(newUserPw);
    }


    @Override
    public List<Member> findMembers() {
        return memberRepository.findMemberAll();
    }

    @Override
    public Member findOne(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findOne(String userId) {
        return memberRepository.findByUserId(userId);
    }

    @Override
    public void delete(Long id) {
        memberRepository.removeMember(id);
    }


}
