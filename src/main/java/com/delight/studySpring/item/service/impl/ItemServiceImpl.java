package com.delight.studySpring.item.service.impl;

import com.delight.studySpring.item.base.Book;
import com.delight.studySpring.item.dto.BookDto;
import com.delight.studySpring.item.entity.Item;
import com.delight.studySpring.item.repository.ItemRepository;
import com.delight.studySpring.item.service.ItemService;
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
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }


    @Override
    public void changeItem(BookDto bookDto) {
        Book book = (Book) itemRepository.findOne(bookDto.getId());
        book.changeBook(bookDto);
    }

    @Override
    public Item findOne(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public List<Item> findItems() {
        return itemRepository.findAll();
    }
}
