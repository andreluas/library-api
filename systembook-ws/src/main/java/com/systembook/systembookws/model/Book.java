package com.systembook.systembookws.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Books")
public class Book {
    @Id
    private String id;
    private String nameBook;
    private String authorBook;

    //#region
    public String getId() {
        return id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public void setId(String id) {
        this.id = id;
    }
    //#endregion  
}