package com.delight.studySpring.order.dto;

import com.delight.studySpring.base.data.Address;
import com.delight.studySpring.order.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Data
@AllArgsConstructor
public class OrderSampleQueryDto {
    private Long orderId;
    private String name; // 주문자
    private LocalDateTime orderDate; // 주문 날짜
    private OrderStatus orderStatus; // 주문 상태
    private Address address;
}
