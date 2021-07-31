package com.systembook.systembookws.service;

import java.util.List;

import com.systembook.systembookws.model.Book;

public interface BookService {
    List<Book> findBooks();
    Book saveBook(Book book);
    Book findId(String id);
    void deleteBook(String id);
    Book updateBook(String id, Book book);
}
