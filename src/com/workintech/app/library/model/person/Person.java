package com.workintech.app.library.model.person;

import com.workintech.app.library.enums.Roles;
import com.workintech.app.library.interfaces.Addable;
import com.workintech.app.library.interfaces.Removable;
import com.workintech.app.library.model.books.Book;

import java.util.*;

public abstract class Person implements Removable, Addable {
    private String name;
    private Roles role;
    private final Map<UUID, Book> books;

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

    public Map<UUID, Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showBooks() {
        if (!books.isEmpty()) {
            for (Book book : books.values()) {
                book.display();
            }
        } else {
            System.out.println("You don't have any book");
        }
    }

    public Roles whoYouAre() {
        return getRole();
    }

    public abstract void showPerson();

}
