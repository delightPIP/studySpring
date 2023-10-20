package com.delight.studySpring.item.dto;

import com.delight.studySpring.item.base.Book;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by delightPIP on 2023/10/20.
 */
@Getter
@Setter
public class BookDto {
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;

    public static BookDto createBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setPrice(book.getPrice());
        bookDto.setStockQuantity(book.getStockQuantity());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setIsbn(book.getIsbn());

        return bookDto;
    }
}
