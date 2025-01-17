package com.workintech.app.library.model.person;

import com.workintech.app.library.enums.Roles;
import com.workintech.app.library.model.books.Book;
import org.jetbrains.annotations.NotNull;

public class Author extends Person {
    public Author(String name) {
        super(name, Roles.AUTHOR);

    }

    @Override
    public void addBook(@NotNull Book book) {
        if (getName().equals(book.getAuthor())) {
            getBooks().put(book.getID(), book);
        } else {
            System.out.println("This is not author's book");
        }
    }

    @Override
    public void removeBook(@NotNull Book book) {
        if (getBooks().containsKey(book.getID())) {
            getBooks().remove(book.getID());
        } else {
            System.out.println("This book is not " + getClass() + "'s list. " + "So, you can not remove");
        }
    }

    @Override
    public void showPerson() {
        System.out.println("-->" + getName() + "<--");
        System.out.println("Role: " + getRole());
        System.out.println("--> Books <--");
        int i = 1;
        for (Book book : getBooks().values()) {
            System.out.println(i++ + ". " + book.getName());
        }
    }

}
