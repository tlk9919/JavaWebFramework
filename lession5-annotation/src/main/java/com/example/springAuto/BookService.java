package com.example.springAuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @classnam BookService
 * @time 16:43
 * @date 2024/10/15
 */
@Service
public class BookService {
@Autowired
@Qualifier("bookRepositoryImpl1")
    private BookRepository repository;

    public boolean save(Book book){
        return repository.save(book);

    }
    public Book findBookByIsbn (String isbn){
        return repository.findBookByIsbn(isbn);
    }

}
