package com.delight.studySpring.order.dto.sample;

import com.delight.studySpring.base.data.Address;
import com.delight.studySpring.order.constant.OrderStatus;
import com.delight.studySpring.order.entity.Order;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Data
public class SampleOrderDto {
    private Long orderId;
    private String name; // 주문자
    private LocalDateTime orderDate; // 주문 날짜
    private OrderStatus orderStatus; // 주문 상태
    private Address address;

    /**
     * DTO 클래스안에서 엔티티를 파라미터로 받는 건 괜찮다.
     * 결국 외부로 노출만 하지 않는다면 상관없다
     **/
    public SampleOrderDto(Order order) {
        this.orderId = order.getId();
        this.name = order.getMember().getName();
        this.orderDate = order.getOrderDate();
        this.orderStatus = order.getStatus();
        this.address = order.getDelivery().getAddress();
    }
}
