package com.example.springAuto;

import org.springframework.stereotype.Repository;

/**
 * @author admin
 * @classnam BookRepositoryImpl1
 * @time 16:31
 * @date 2024/10/15
 */
@Repository//对应Dao
public class BookRepositoryImpl1 implements BookRepository  {

    @Override
    public Boolean save(Book book) {
        System.out.println("将传递过来的book对象存入数据库1");
        return true;
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        System.out.println("根据传递过来的isbn号从数据据库1查询记录，构造book对象");
        Book book= new Book();
        book.setIsbn(isbn);
        book.setTitle("《编程语言》");
        book.setAuthor("zs");
        return book;
    }
}
