package com.delight.studySpring.order.service;

import com.delight.studySpring.base.dto.Result;
import com.delight.studySpring.order.dto.OrderQueryDto;
import com.delight.studySpring.order.dto.OrderSampleQueryDto;
import com.delight.studySpring.order.dto.OrderSearchDto;
import com.delight.studySpring.order.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Service
public interface OrderService {

    @Transactional
    Long order(Long memberId, Long itemId, int count);

    @Transactional
    void cancelOrder(Long id);

    List<Order> findOrders(OrderSearchDto orderSearchDto);

    List<Order> findOrderWithItem();

    List<Order> findAllWithMemberDelivery(int offset, int limit);

    List<Order> findAllWithMemberDelivery();

    List<OrderQueryDto> findOrderQueryDtoList();

    List<OrderSampleQueryDto> findOrderDtoList();
}
