package com.delight.studySpring.item.base;

import com.delight.studySpring.item.dto.BookDto;
import com.delight.studySpring.item.entity.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@DiscriminatorValue("B")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Book extends Item {
    private String author;
    private String isbn;

    public static Book create(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);

        return book;
    }

    // 정적 팩토리 메서드
    public static Book createBook(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setPrice(bookDto.getPrice());
        book.setStockQuantity(bookDto.getStockQuantity());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());

        return book;
    }

    // 변경 메서드
    public void changeBook(BookDto bookDto) {
        super.changeItem(bookDto.getName(), bookDto.getPrice(), bookDto.getStockQuantity());
        this.author = bookDto.getAuthor();
        this.isbn = bookDto.getIsbn();
    }
}
