package com.delight.studySpring.api;

import com.delight.studySpring.order.dto.OrderDto;
import com.delight.studySpring.order.dto.OrderQueryDto;
import com.delight.studySpring.order.dto.OrderSearchDto;
import com.delight.studySpring.order.entity.Order;
import com.delight.studySpring.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;

    /**
     * Fetch JOIN 방식
     */
    @GetMapping("/ordersXX")
    public List<OrderDto> ordersXX() {
        List<Order> orderList = orderService.findOrderWithItem();

        List<OrderDto> result = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto dto = new OrderDto(order);
            result.add(dto);
        }

        return result;
    }

    /**
     * paging
     */
    @GetMapping("/orders/page")
    public List<OrderDto> ordersPage(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "100") int limit) {
        List<Order> orderList = orderService.findAllWithMemberDelivery(offset, limit);

        List<OrderDto> result = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto dto = new OrderDto(order);
            result.add(dto);
        }

        return result;
    }

    @GetMapping("/orders")
    public List<OrderQueryDto> orders() {
        return orderService.findOrderQueryDtoList();
    }

}
