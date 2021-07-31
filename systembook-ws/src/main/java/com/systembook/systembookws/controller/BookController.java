package com.systembook.systembookws.controller;

import java.util.List;

import com.systembook.systembookws.model.Book;
import com.systembook.systembookws.service.BookServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    BookServiceImpl service;

    @GetMapping
    public List<Book> listBooks() {
        return service.findBooks();
    }

    @GetMapping(value = "/{id}")
    public Book findBookId(@PathVariable String id) {
        return service.findId(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable String id) {
        service.deleteBook(id);
    }

    @PutMapping(value = "/{id}")
    public Book updateBookId(@PathVariable String id, @RequestBody Book book) {
        return service.updateBook(id, book);
    }
} 