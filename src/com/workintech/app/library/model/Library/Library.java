package com.workintech.app.library.model.Library;


import com.workintech.app.library.Enums.Status;
import com.workintech.app.library.Interfaces.Showable;
import com.workintech.app.library.model.Books.Book;
import com.workintech.app.library.model.Person.Reader;

import java.util.*;


public class Library implements Showable {
    private final Map<UUID,Book> books;
    private final Map<UUID,Reader> readers;
    private final Map<UUID,Bill> bills;
    public Library() {
        this.books = new HashMap<>();
        this.readers = new HashMap<>();
        this.bills = new HashMap<>();
    }

    public Map<UUID,Book> getBooks() {
        return books;
    }
    public Map<UUID,Reader> getReaders() {
        return readers;
    }
    public void newBook(Book book){
        books.put(book.getID(),book);
    }
    public void registerReader(Reader reader){
        readers.put(reader.getID(),reader);
    }

    public Map<UUID, Bill> getBills() {
        return bills;
    }

    @Override
    public void showBooks(){
        for(Book book: books.values()){
            book.display();
            if(book.getStatus().equals(Status.BORROWED)){
                System.out.println("Borrowed by "+book.getOwner().getName());
            }
        }
    }
    @Override
    public void showMembers(){
        for(Reader reader: readers.values()){
            reader.showPerson();
        }
    }

    @Override
    public void showReader(Reader reader) {
        reader.showPerson();
    }

    @Override
    public void showBook(Book book) {
        book.display();
    }

}
