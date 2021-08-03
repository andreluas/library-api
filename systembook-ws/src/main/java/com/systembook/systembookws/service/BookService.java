package com.systembook.systembookws.service;

import java.util.List;
import java.util.Optional;

import com.systembook.systembookws.model.Book;

public interface BookService {
    List<Book> findBooks();
    Book saveBook(Book book);
    Optional<Book> findId(String id);
    void deleteBook(String id);
    Optional<Book> updateBook(String id, Book book);
}
