package com.workintech.app.library.model.Person;

import com.workintech.app.library.Enums.Roles;
import com.workintech.app.library.Enums.Status;
import com.workintech.app.library.model.Books.Book;

import java.util.*;

public abstract class Person {
    private String name;
    private Roles role;
    private Map<UUID,Book> books;
    public Person(String name, Roles role) {
        this.name = name;
        this.role = role;
        this.books = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public Roles getRole() {
        return role;
    }

    public Map<UUID,Book> getBooks() {
        return books;
    }
    public void showBooks(){
        for(Book book: books.values()){
            book.display();
        }
    }

    public Roles whoYouAre(){
        return getRole();
    }


    public void showPerson(){
        System.out.println("-->"+getName()+"<--");
        System.out.println("Role: "+getRole());
        System.out.println("--> Books <--");
        for(Book book : books.values()){
            System.out.println(book.getName());
        }
    }

    public abstract void addBook(Book book);
    /* TODO
    *  create Remove method*/
}
