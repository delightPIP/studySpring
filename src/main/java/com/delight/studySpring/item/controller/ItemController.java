package com.delight.studySpring.item.controller;

import com.delight.studySpring.item.service.ItemService;
import com.delight.studySpring.item.service.impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
}
