package com.example.springAuto;

import org.springframework.stereotype.Repository;

/**
 * @author admin
 * @classnam BookRepositoryImpl2
 * @time 16:41
 * @date 2024/10/15
 */
@Repository
public class BookRepositoryImpl2 implements  BookRepository {
    @Override
    public Boolean save(Book book) {
        System.out.println("将传递进来的book对象存入数据库2");
        return true;
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        System.out.println("根据传递进来的isbn号从数据库2查询记录，构造book对象");
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle("《编程语言》");
        book.setAuthor("zs");
        return book;
    }
}
