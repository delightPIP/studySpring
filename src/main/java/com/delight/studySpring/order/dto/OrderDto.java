package com.delight.studySpring.order.dto;

import com.delight.studySpring.base.data.Address;
import com.delight.studySpring.order.constant.OrderStatus;
import com.delight.studySpring.order.entity.Order;
import com.delight.studySpring.orderItem.dto.OrderItemDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Data
public class OrderDto {
    private Long orderId;
    private String name; // 주문자
    private LocalDateTime orderDate; // 주문 날짜
    private OrderStatus orderStatus; // 주문 상태
    private Address address; // 값 타입은 노출 ㄱㅊ
    private List<OrderItemDto> orderItems;

    public OrderDto(Order order) {
        this.orderId = order.getId();
        this.name = order.getMember().getName();
        this.orderDate = order.getOrderDate();
        this.orderStatus = order.getStatus();
        this.address = order.getDelivery().getAddress();
        orderItems = order.getOrderItems().stream()
                .map(OrderItemDto::new)
                .collect(Collectors.toList());
    }
}
