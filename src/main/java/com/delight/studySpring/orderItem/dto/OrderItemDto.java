package com.delight.studySpring.orderItem.dto;

import com.delight.studySpring.orderItem.entity.OrderItem;
import lombok.Data;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Data
public class OrderItemDto {
    private String itemName; // 상품 이름
    private int orderPrice; // 상품 가격
    private int count; // 수량

    public OrderItemDto(OrderItem orderItem) {
        this.itemName = orderItem.getItem().getName(); // ??
        this.orderPrice = orderItem.getOrderPrice();
        this.count = orderItem.getCount();
    }
}
