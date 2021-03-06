package com.systembook.systembookws.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.systembook.systembookws.service.BookServiceImpl;
import com.systembook.systembookws.shared.BookDto;
import com.systembook.systembookws.view.model.BookRequestObs;
import com.systembook.systembookws.view.model.BookResponse;
import com.systembook.systembookws.view.model.BookResponseObs;

import org.modelmapper.ModelMapper;
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
    public ResponseEntity<List<BookResponse>> listBooks() {
        List<BookDto> bookDto = service.findBooks();
        List<BookResponse> bookResponse = bookDto.stream()
            .map(b -> new ModelMapper().map(b, BookResponse.class))
            .collect(Collectors.toList());  
        return new ResponseEntity<>(bookResponse, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDto> findBookId(@PathVariable String id) {
        Optional<BookDto> opBook = service.findId(id);

        if(opBook.isPresent()) {
            return new ResponseEntity<>(opBook.get(), HttpStatus.FOUND);
        }
    
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<BookResponseObs> addBook(@RequestBody BookRequestObs book) {
        ModelMapper bookMap = new ModelMapper();
        BookDto bookDto = bookMap.map(book, BookDto.class);
        bookDto = service.saveBook(bookDto);
        BookResponseObs bookResponse = bookMap.map(bookDto, BookResponseObs.class);

        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        service.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDto> updateBookId(@PathVariable String id, @RequestBody BookDto book) {
        Optional<BookDto> opBook = service.updateBook(id, book);

        if(opBook.isPresent()) {
            return new ResponseEntity<>(opBook.get(), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
} 