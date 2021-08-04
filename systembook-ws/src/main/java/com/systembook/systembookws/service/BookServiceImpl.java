package com.systembook.systembookws.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // Buscar todos
    @Override
    public List<BookDto> findBooks() {
        List<Book> listBook = repository.findAll(); 
        
        return listBook.stream()
            .map(b -> new ModelMapper().map(b, BookDto.class))
            .collect(Collectors.toList());
    }

    // Cadastrar
    @Override
    public BookDto saveBook(BookDto book) {
        ModelMapper mapper = new ModelMapper();
        Book bookForSave = mapper.map(book, Book.class); 
        bookForSave = repository.save(bookForSave);
        return mapper.map(bookForSave, BookDto.class);
    }

    // Busca por Id
    @Override
    public Optional<BookDto> findId(String id) {
        Optional<Book> opBook = repository.findById(id);
        
        if(opBook.isPresent()) {
            return Optional.of(new ModelMapper().map(opBook.get(), BookDto.class));
        } 
        
        return Optional.empty();
    }

    // Deletar
    @Override
    public void deleteBook(String id) {
        repository.deleteById(id);
    }

    // Atualizar
    @Override
    public Optional<BookDto> updateBook(String id, BookDto book) {
        ModelMapper mapper = new ModelMapper();
        Optional<Book> opBook = repository.findById(id); 
        Book bookForSave = mapper.map(book, Book.class);
 
        if(opBook.isPresent()) {
            bookForSave.setId(id);
            bookForSave = repository.save(bookForSave);
            return Optional.of(mapper.map(bookForSave, BookDto.class));
        }

        return Optional.empty();
    }    
}
