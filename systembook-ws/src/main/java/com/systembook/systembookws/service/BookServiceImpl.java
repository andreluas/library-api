package com.systembook.systembookws.service;

import java.util.List;
import java.util.Optional;

import com.systembook.systembookws.model.Book;
import com.systembook.systembookws.repository.BookRepository;
import com.systembook.systembookws.shared.BookDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;

    @Override
    public List<BookDto> findBooks() {
        return repository.findAll();
    }

    @Override
    public BookDto saveBook(BookDto book) {
        return repository.save(book);
    }

    @Override
    public Optional<BookDto> findId(String id) {
        Optional<Book> opBook = repository.findById(id);
        
        if(opBook.isPresent()) {
            return Optional.of(new ModelMapper().map(opBook.get(), BookDto.class));
        } 
        
        return Optional.empty();
    }

    @Override
    public void deleteBook(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<BookDto> updateBook(String id, BookDto book) {
        Optional<Book> opBook = repository.findById(id); 
 
        if(opBook.isPresent()) {
            book.setId(id);
            return Optional.of(repository.save(book));
        }

        return Optional.empty();
    }    
}
