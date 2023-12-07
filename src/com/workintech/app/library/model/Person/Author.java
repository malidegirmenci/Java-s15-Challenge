package com.workintech.app.library.model.Person;

import com.workintech.app.library.Enums.Roles;
import com.workintech.app.library.model.Books.Book;


public class Author extends Person {
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
    @Override
    public void removeBook(Book book){
        if(getBooks().containsKey(book.getID())){
            getBooks().remove(book.getID());
        }else{
            System.out.println("This book is not "+getClass()+"'s list. "+"So, you can not remove");
        }
    }

    @Override
    public void showPerson() {
        System.out.println("-->" + getName() + "<--");
        System.out.println("Role: " + getRole());
        System.out.println("--> Books <--");
        int i=1;
        for (Book book : getBooks().values()) {
            System.out.println(i++ +". "+book.getName());
        }
    }
}
