package com.systembook.systembookws.service;

import java.util.List;
import java.util.Optional;

import com.systembook.systembookws.model.Book;
import com.systembook.systembookws.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;

    @Override
    public List<Book> findBooks() {
        return repository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Optional<Book> findId(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteBook(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Book> updateBook(String id, Book book) {
        Optional<Book> opBook = repository.findById(id); 
 
        if(opBook.isPresent()) {
            book.setId(id);
            return Optional.of(repository.save(book));
        }

        return Optional.empty();
    }    
}
