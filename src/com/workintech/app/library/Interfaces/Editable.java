package com.workintech.app.library.Interfaces;


import com.workintech.app.library.model.Books.Book;

public interface Editable {
    void editBook(Book book, String author, String name, double price, String releaseYear, int pages, String summary);

}
