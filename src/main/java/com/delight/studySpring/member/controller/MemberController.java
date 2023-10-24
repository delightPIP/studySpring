package com.delight.studySpring.member.controller;

import com.delight.studySpring.member.dto.MemberDto;
import com.delight.studySpring.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("members", memberService.findMembers());
        return "members/list";
    }

    @GetMapping("/add")
    public String writeForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/form";
    }

}
