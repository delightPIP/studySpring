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
public class OrderItemQueryDto {
    private Long orderId;
    private String name; //주문자명
    private LocalDateTime localDateTime;

    private OrderStatus orderStatus;

    private Address address;
}
