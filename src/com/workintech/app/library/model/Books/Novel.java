package com.workintech.app.library.model.Books;

import com.workintech.app.library.Enums.Status;

public class Novel extends Book{
    public Novel(String author, String name, double price, String releaseYear, int pages, String summary) {
        super( author, name, price, releaseYear, pages, summary);
    }
}
