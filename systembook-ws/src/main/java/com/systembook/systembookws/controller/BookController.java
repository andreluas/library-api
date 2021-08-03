package com.systembook.systembookws.controller;

import java.util.List;
import java.util.Optional;

import com.systembook.systembookws.model.Book;
import com.systembook.systembookws.service.BookServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Book>> listBooks() {
        return new ResponseEntity<>(service.findBooks(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findBookId(@PathVariable String id) {
        Optional<Book> opBook = service.findId(id);

        if(opBook.isPresent()) {
            return new ResponseEntity<>(opBook.get(), HttpStatus.FOUND);
        }
    
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(service.saveBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        service.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> updateBookId(@PathVariable String id, @RequestBody Book book) {
        return new ResponseEntity<>(service.updateBook(id, book), HttpStatus.ACCEPTED);
    }
} 