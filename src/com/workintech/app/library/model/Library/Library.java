package com.workintech.app.library.model.Library;

import com.workintech.app.library.enums.Status;
import com.workintech.app.library.interfaces.Removable;
import com.workintech.app.library.interfaces.Showable;
import com.workintech.app.library.model.Books.Book;
import com.workintech.app.library.model.Person.Reader;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Library implements Showable, Removable {
    private final Map<UUID, Book> books;
    private final Map<UUID, Reader> readers;
    private final Map<UUID, Bill> bills;

    public Library() {
        this.books = new HashMap<>();
        this.readers = new HashMap<>();
        this.bills = new HashMap<>();
    }

    public Map<UUID, Book> getBooks() {
        return books;
    }
    public Map<UUID, Reader> getReaders() {
        return readers;
    }
    public Map<UUID, Bill> getBills() {
        return bills;
    }

    public void newBook(Book book) {
        this.books.put(book.getID(), book);
    }

    public void registerReader(Reader reader) {
        readers.put(reader.getID(), reader);
    }

    public void removeReader(@NotNull Reader reader){this.readers.remove(reader.getID());}

    @Override
    public void removeBook(@NotNull Book book){this.books.remove(book.getID());}


    @Override
    public void showBooks() {
        Set<Book> books = new TreeSet<>(this.books.values());
        for(Book book: books){
            book.display();
            if (book.getStatus().equals(Status.BORROWED)) {
                System.out.println("Borrowed by " + book.getOwner().getName());
            }
        }
    }
    @Override
    public void showMembers() {
        for (Reader reader : readers.values()) {
            reader.showPerson();
        }
    }
    @Override
    public void showReader(@NotNull Reader reader) {
        reader.showPerson();
    }

    @Override
    public void showBook(@NotNull Book book) {
        book.display();
    }

    public void showBills() {
        Set<Bill> bills = new TreeSet<>(this.bills.values());
        for(Bill bill: bills){
            System.out.println(bill);
        }
    }
}
