package com.delight.studySpring.order.dto;

import com.delight.studySpring.base.data.Address;
import com.delight.studySpring.order.constant.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Data
public class OrderQueryDto  {
    private Long orderId;
    private String name; // 주문자
    private LocalDateTime orderDate; // 주문 날짜
    private OrderStatus orderStatus; // 주문 상태
    private Address address;
    private List<OrderItemQueryDto> orderItems;

    public OrderQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
    };
}
