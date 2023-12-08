package com.workintech.app.library.interfaces;


import com.workintech.app.library.model.Books.Book;
import com.workintech.app.library.model.Person.Reader;

public interface Editable {
    void editBook(Book book, String author, String name, double price, String releaseYear, int pages, String summary);
    void editReader(Reader reader, String name, String dateOfMembership, String address, String phoneNo, String type);
}
