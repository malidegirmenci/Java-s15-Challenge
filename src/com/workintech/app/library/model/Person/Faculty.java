package com.workintech.app.library.model.Person;

import com.workintech.app.library.model.Books.Book;

public class Faculty extends Reader {
    public Faculty(String name, String dateOfMembership, String address, String phoneNo) {
        super(name, dateOfMembership, address, phoneNo);
    }

    @Override
    public void addBook(Book book) {

    }
}
