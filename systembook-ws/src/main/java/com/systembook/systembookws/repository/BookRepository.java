package com.systembook.systembookws.repository;

import com.systembook.systembookws.model.Book;

import org.springframework.data.mongodb.repository.MongoRepository;
// Repository -> Interface que realiza o acesso ao banco
public interface BookRepository extends MongoRepository<Book, String> {
    
}