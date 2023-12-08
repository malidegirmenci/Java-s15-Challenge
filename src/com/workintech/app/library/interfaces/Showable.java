package com.workintech.app.library.interfaces;

import com.workintech.app.library.model.books.Book;
import com.workintech.app.library.model.person.Reader;

public interface Showable {
    void showReader(Reader reader);
    void showBook(Book book);
    void showBooks();
    void showReaders();
}
