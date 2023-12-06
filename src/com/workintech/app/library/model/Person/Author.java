package com.workintech.app.library.model.Person;

import com.workintech.app.library.Enums.Roles;
import com.workintech.app.library.model.Books.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Author extends Person{
    public Author(String name) {
        super(name,Roles.AUTHOR);

    }
    @Override
    public void addBook(Book book){
        if(getName().equals(book.getAuthor())){
            getBooks().put(book.getID(),book);
        }else{
            System.out.println("This is not author's book");
        }
    }
}
