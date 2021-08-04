package com.systembook.systembookws.shared;

public class BookDto {
    private String id;
    private String nameBook;
    private String authorBook;

    //#region
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    //#endregion
}
