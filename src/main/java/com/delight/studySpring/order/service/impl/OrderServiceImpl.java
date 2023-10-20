package com.delight.studySpring.order.service.impl;

import com.delight.studySpring.delivery.constant.DeliveryStatus;
import com.delight.studySpring.delivery.entity.Delivery;
import com.delight.studySpring.item.entity.Item;
import com.delight.studySpring.order.dto.OrderQueryDto;
import com.delight.studySpring.order.dto.OrderSampleQueryDto;
import com.delight.studySpring.orderItem.entity.OrderItem;
import com.delight.studySpring.item.service.ItemService;
import com.delight.studySpring.member.entity.Member;
import com.delight.studySpring.member.service.MemberService;
import com.delight.studySpring.order.dto.OrderSearchDto;
import com.delight.studySpring.order.entity.Order;
import com.delight.studySpring.order.repository.OrderRepository;
import com.delight.studySpring.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberService memberService;
    private final ItemService itemService;
    private final OrderRepository orderRepository;


    @Override
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberService.findOne(memberId);
        Item item = itemService.findOne(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddressAndStatus(member.getAddress(), DeliveryStatus.READY);

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    @Override
    @Transactional
    public void cancelOrder(Long id) {
        Order order = orderRepository.findOne(id);
        order.cancel();
    }

    @Override
    public List<Order> findOrders(OrderSearchDto orderSearchDto) {
        return orderRepository.findAllByString(orderSearchDto);
    }

    @Override
    public List<Order> findOrderWithItem() {
        return orderRepository.findAllWithItem();
    }

    @Override
    public List<Order> findAllWithMemberDelivery(int offset, int limit) {
        return orderRepository.findAllWithMemberDelivery(offset, limit);
    }

    @Override
    public List<Order> findAllWithMemberDelivery() {
        return orderRepository.findAllWithMemberDelivery();
    }

    @Override
    public List<OrderQueryDto> findOrderQueryDtoList() {
        return orderRepository.findOrderQueryDtoList();
    }

    @Override
    public List<OrderSampleQueryDto> findOrderDtoList() {
        return orderRepository.findOrderDtoList();
    }


}
