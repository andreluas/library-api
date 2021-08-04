package com.systembook.systembookws.service;

import java.util.List;
import java.util.Optional;

import com.systembook.systembookws.shared.BookDto;

public interface BookService {
    List<BookDto> findBooks();
    BookDto saveBook(BookDto book);
    Optional<BookDto> findId(String id);
    void deleteBook(String id);
    Optional<BookDto> updateBook(String id, BookDto book);
}
