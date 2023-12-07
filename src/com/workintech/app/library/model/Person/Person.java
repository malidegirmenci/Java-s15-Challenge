package com.workintech.app.library.model.Person;

import com.workintech.app.library.Enums.Roles;
import com.workintech.app.library.Enums.Status;
import com.workintech.app.library.Interfaces.Addable;
import com.workintech.app.library.Interfaces.Removable;
import com.workintech.app.library.model.Books.Book;

import java.util.*;

public abstract class Person implements Addable, Removable {
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
        if(!books.isEmpty()){
            for(Book book: books.values()){
                book.display();
                if(book.getStatus().equals(Status.BORROWED)){
                    System.out.println("Borrowed by "+book.getOwner().getName());
                }
            }
        }else{
            System.out.println("You don't have any book");
        }
    }

    public Roles whoYouAre(){
        return getRole();
    }

    public abstract void showPerson();

}
