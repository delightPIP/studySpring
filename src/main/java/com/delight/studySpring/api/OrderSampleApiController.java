package com.delight.studySpring.api;

import com.delight.studySpring.base.dto.Result;
import com.delight.studySpring.order.dto.OrderSampleQueryDto;
import com.delight.studySpring.order.entity.Order;
import com.delight.studySpring.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderSampleApiController {
    private final OrderService orderService;

    @GetMapping("/sample-orders")
    public Result<List<OrderSampleQueryDto>> order() {
        List<OrderSampleQueryDto> orderDtoList = orderService.findOrderDtoList();
        return new Result<>(orderDtoList.size(), orderDtoList);
    }

}
