package com.delight.studySpring.item.service;

import com.delight.studySpring.item.dto.BookDto;
import com.delight.studySpring.item.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Service
@Transactional(readOnly = true)

public interface ItemService {

    @Transactional
    void saveItem(Item item);

    @Transactional
    void changeItem(BookDto bookDto);

    Item findOne(Long id);

    List<Item> findItems();

}
