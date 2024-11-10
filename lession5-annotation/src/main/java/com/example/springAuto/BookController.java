package com.example.springAuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author admin
 * @classnam BookController
 * @time 16:50
 * @date 2024/10/15
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    public void saveBook(){
        Book bookFromFont = new Book();
        bookFromFont.setIsbn("1001");
        bookFromFont.setTitle("《前端传递过来的》");
        bookFromFont.setAuthor("front");
        bookService.save(bookFromFont);
    }
    public Book findBookByIsbn(String isbn){
        return bookService.findBookByIsbn(isbn);
    }
}
