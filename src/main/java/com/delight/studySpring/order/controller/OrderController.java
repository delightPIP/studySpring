package com.delight.studySpring.order.controller;

import com.delight.studySpring.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Created by delightPIP on 2023/10/20.
 */

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

}
