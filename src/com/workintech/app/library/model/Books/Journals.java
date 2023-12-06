package com.workintech.app.library.model.Books;

import com.workintech.app.library.Enums.Status;
import com.workintech.app.library.model.Books.Book;

public class Journals extends Book {
    public Journals( String author, String name, double price, String releaseYear, int pages, String summary) {
        super( author, name, price,  releaseYear, pages, summary);
    }
}
