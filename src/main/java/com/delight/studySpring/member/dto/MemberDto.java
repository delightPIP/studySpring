package com.delight.studySpring.member.dto;

import com.delight.studySpring.base.data.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Data
@AllArgsConstructor
public class MemberDto {
    private String name;
    private Address address;
}
