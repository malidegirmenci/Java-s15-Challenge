package com.workintech.app.library.Interfaces;

import com.workintech.app.library.model.Books.Book;
import com.workintech.app.library.model.Person.Reader;

public interface Showable {
    void showReader(Reader reader);
    void showBook(Book book);
    void showBooks();
    void showMembers();
}
