package com.delight.studySpring.member.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by delightPIP on 2023/10/24.
 */
@Getter @Setter
public class MemberForm {
    @NotEmpty(message = "아이디는 필수 입니다.")
    private String user_id;
    @NotEmpty(message = "비밀번호는 필수 입니다.")
    private String user_pw;
    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
