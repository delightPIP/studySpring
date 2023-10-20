package com.delight.studySpring.order.dto;

import com.delight.studySpring.order.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by delightPIP on 2023/10/20.
 */

@Getter @Setter
public class OrderSearchDto {
    private String memberName;
    private OrderStatus orderStatus; // [ORDER, CANCEL]
}
