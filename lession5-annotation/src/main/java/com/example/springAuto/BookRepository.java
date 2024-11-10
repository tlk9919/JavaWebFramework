package com.example.springAuto;

public interface BookRepository {
    public Boolean save(Book book);
    public Book findBookByIsbn(String isbn);
}
