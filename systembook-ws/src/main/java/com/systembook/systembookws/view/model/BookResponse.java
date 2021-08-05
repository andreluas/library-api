package com.systembook.systembookws.view.model;

public class BookResponse {
    private String nameBook;
    private String authorBook;

    //#region
    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }
    //#endregion

    public String getLibraryBooks() {
        return String.format("%s - %s", this.nameBook, this.authorBook);
    }
}
