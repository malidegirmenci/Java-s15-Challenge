package com.workintech.app.library.model.Library;


import com.workintech.app.library.Enums.Status;
import com.workintech.app.library.model.Books.Book;

import com.workintech.app.library.model.Person.Reader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

public class Librarian {
    private final String password;
    private String name;
    private Library library;

    public Librarian(String name, String password, Library library) {
        this.name = name;
        this.password = password;
        this.library = library;
    }


    public boolean searchBook(String name) {
        for (Book book : library.getBooks().values()) {
            if (book.getName().equals(name)) {
                System.out.println(book.getName() + " registered in the system");
                book.display();
                return true;
            }
        }
        System.out.println("The book is not register in the system");
        return false;
    }

    public boolean verifyMember(UUID uuid) {
        for (Map.Entry<UUID, Reader> reader : library.getReaders().entrySet()) {
            if (uuid.equals(reader.getKey())) {
                //System.out.println(reader.getValue().getName() + " is in reader system");
                return true;
            }
        }
        System.out.println("The member is not in reader system");
        return false;
    }

    public LocalDate convertLD(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }

    public void issueBook(Reader reader, Book book, String date) {
        LocalDate dateOfTaken = convertLD(date);
        LocalDate finalDeliveryDate = dateOfTaken.plusDays(15);
        LocalDate deadline = dateOfTaken.plusDays(90);
        if (verifyMember(reader.getID())) {
            if (book.getStatus().equals(Status.AVAILABLE)) {
                reader.addBook(book);
                book.setDateOfTaken(dateOfTaken);
                book.setFinalDeliveryDate(finalDeliveryDate);
                book.setDeadline(deadline);
                System.out.println(book.getName() + " borrowed to " + reader.getName());
            }else{
                System.out.println(book.getName() + " is borrowed by " + book.getOwner().getName());
            }
        } else {
            System.out.println(reader.getName() + " must be register to system");
        }
    }

    public void calculateFine(Reader reader) {
        LocalDate today = LocalDate.now();
        LocalDate deadline;
        int penaltyDays = 0;
        double penaltyAmount = 0;
        System.out.println("Mr/s " + reader.getName());
        for (Book book : reader.getBooks().values()) {
            if (today.isAfter(book.getFinalDeliveryDate())) {
                if (today.isAfter(book.getDeadline())) {
                    penaltyDays = book.getDeadline().until(today).getDays();
                    penaltyAmount = (penaltyDays * 1.5) + book.getPrice();
                    System.out.println(
                            "You passed deadline of book with " + penaltyDays + " days. " +
                                    "So, you must pay penalty and price of book " + penaltyAmount + "₺.");
                } else {
                    penaltyDays = book.getFinalDeliveryDate().until(today).getDays();
                    penaltyAmount = penaltyDays * 1.5;
                    System.out.println(
                            "You passed final delivery date with " + penaltyDays + " days. " +
                                    " So, you must pay fine " + penaltyAmount + "₺.");
                }
            } else {
                System.out.println("You don't have penalty for " + book.getName() + "Thank you!");
            }
        }
    }
}
