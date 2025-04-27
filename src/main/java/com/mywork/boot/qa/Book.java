package com.mywork.boot.qa;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
public class Book {
    private String title;
    private String author;

    public static void main(String[] args) {
        Book book = new Book();

        System.out.println(book.getAuthor());
        System.out.println(book.getTitle());
    }
}
