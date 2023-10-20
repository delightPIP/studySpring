package com.delight.studySpring.api;

import com.delight.studySpring.base.data.Address;
import com.delight.studySpring.base.dto.Result;
import com.delight.studySpring.member.dto.MemberDto;
import com.delight.studySpring.member.entity.Member;
import com.delight.studySpring.member.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/members")
    public Result<List<MemberDto>> members() {
        List<Member> memberList = memberService.findMembers();

        List<MemberDto> members = new ArrayList<>();
        for (Member member : memberList) {
            MemberDto dto = new MemberDto(member.getName(), member.getAddress());
            members.add(dto);
        }

        return new Result<>(members.size(), members);
    }


    @Data
    static class CreateMemberRequest {
        @NotEmpty
        private String name;
        private Address address;
    }

    @Data
    @AllArgsConstructor
    static class CreateMemberResponse {
        private Long id;
    }

    @PostMapping("/save")
    public CreateMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request) {
        Member member = Member.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }


    @Data
    static class UpdateMemberRequest {
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private Long id;
        private String name;
    }

    @PutMapping("/members/{id}")
    public UpdateMemberResponse updateMember(
            @PathVariable("id") Long id,
            @RequestBody UpdateMemberRequest request) {

        memberService.updateName(id, request.getName());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponse(findMember.getId(), findMember.getName());
    }

    @Data
    static class UpdateMemberPasswordRequest {
        private String password;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberPasswordResponse {
        private Long id;
    }

    @PutMapping("/members/account/{id}")
    public UpdateMemberPasswordResponse updateMemberPassword(
            @PathVariable("id") Long id,
            @RequestBody UpdateMemberPasswordRequest request) {
        memberService.updateUserPw(id, request.getPassword());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberPasswordResponse(findMember.getId());
    }

    @Data
    @AllArgsConstructor
    static class DeleteMemberResponse {
        private Long id;
    }
    @DeleteMapping("/members/{id}")
    public DeleteMemberResponse deleteMember(@PathVariable("id") Long id) {
        memberService.delete(id);
        return new DeleteMemberResponse(id);
    }



}
