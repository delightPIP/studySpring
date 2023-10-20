package com.delight.studySpring.member.entity;

import com.delight.studySpring.base.data.Address;
import com.delight.studySpring.base.entity.BaseEntity;
import com.delight.studySpring.order.entity.Order;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Member extends BaseEntity {

    private String user_id;
    private String user_pw;
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();

    public Member(String user_id, String user_pw, String name, Address address) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.name = name;
        this.address = address;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeUserPw(String newUserPw) {
        this.user_pw = newUserPw;
    }
}
