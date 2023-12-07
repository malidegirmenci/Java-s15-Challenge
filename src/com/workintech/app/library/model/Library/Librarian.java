package com.workintech.app.library.model.Library;


import com.workintech.app.library.Enums.Status;
import com.workintech.app.library.Interfaces.Editable;
import com.workintech.app.library.model.Books.Book;
import com.workintech.app.library.model.Person.Reader;
import com.workintech.app.library.utils.Helper;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

public class Librarian implements Editable {
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

    public void checkDamaged(Reader reader, Book book, Status status) {
        if (status.equals(Status.DAMAGED)) {
            reader.getBooks().get(book.getID()).setStatus(Status.DAMAGED);
            System.out.println("You returned to the book damaged");
        } else {
            System.out.println("Thank you. The book is in good condition. You can deliver the book.");
            reader.getBooks().get(book.getID()).setStatus(Status.UNDAMAGED);
        }
    }

    public void issueBook(Reader reader, Book book, String date) {
        LocalDate dateOfTaken = Helper.convertLD(date);
        LocalDate finalDeliveryDate = dateOfTaken.plusDays(15);
        LocalDate deadline = dateOfTaken.plusDays(90);
        if (verifyMember(reader.getID())) {
            if (reader.getMaxBookLimit() > 0) {
                if (book.getStatus().equals(Status.AVAILABLE)) {
                    book.update_status(Status.BORROWED);
                    book.setDateOfTaken(dateOfTaken);
                    book.setFinalDeliveryDate(finalDeliveryDate);
                    book.setDeadline(deadline);
                    book.setOwner(reader);
                    reader.addBook(book);
                    System.out.println(book.getName() + " borrowed to " + reader.getName());
                } else {
                    System.out.println(book.getName() + " is borrowed by " + book.getOwner().getName());
                }
            } else {
                System.out.println("You already five books. So you can not any books");
            }
        } else {
            System.out.println(reader.getName() + " must be register to system");
        }
    }

    public void returnBook(Reader reader, Book book) {
        if (book.getStatus().equals(Status.UNDAMAGED)) {
            if (verifyMember(reader.getID())) {
                if (reader.getBooks().containsKey(book.getID())) {
                    book.update_status(Status.AVAILABLE);
                    book.setDateOfTaken(null);
                    book.setFinalDeliveryDate(null);
                    book.setDeadline(null);
                    book.setOwner(null);
                    reader.removeBook(book);
                    System.out.println(book.getName() + " was delivered by " + reader.getName());
                } else {
                    System.out.println("This book is not your list. So you can not delivered this book.");
                }
            } else {
                System.out.println("You are not registered in our library system. So, you can not delivered any book");
            }
        } else if (book.getStatus().equals(Status.DAMAGED)) {
            reader.removeBook(book);
            library.getBooks().remove(book.getID());
            System.out.println("You delivered the book damaged, we will repair the book.");
        }
    }

    public double calculateFine(Book book) {
        LocalDate today = LocalDate.now();
        int penaltyDays = 0;
        double penaltyAmount = 0;
        if (book.getStatus().equals(Status.DAMAGED)) {
            penaltyAmount += book.getPrice();
            System.out.println(
                    "You delivered the book damaged. So, you must pay "+book.getName()+"'s price");
        }
        if (today.isAfter(book.getFinalDeliveryDate())) {
            if (today.isAfter(book.getDeadline())) {
                penaltyDays = book.getDeadline().until(today).getDays();
                penaltyAmount = (penaltyDays * 1.5) + book.getPrice();
                System.out.println(
                        "You passed deadline of " + book.getName() + " with " + penaltyDays + " days.");
            } else {
                penaltyDays = book.getFinalDeliveryDate().until(today).getDays();
                penaltyAmount = penaltyDays * 1.5;
                System.out.println("You passed final delivery date of "+book.getName() + " with " + penaltyDays + " days.");
            }
        } else {
            System.out.println("You don't have penalty for " + book.getName() + ". Thank you!");
        }
        return penaltyAmount;
    }


    public void createBill(Reader reader) {
        LocalDate deliveredDate = LocalDate.now();
        double fines = 0;
        for (Book book : reader.getBooks().values()) {
            fines += calculateFine(book);
        }
        Bill bill = new Bill(deliveredDate, fines, reader.getName());
        library.getBills().put(reader.getID(), bill);
    }

    public void showBill(Reader reader) {
        System.out.println("----> BILL <----");
        System.out.println("Mr/s " + reader.getName());
        for (Bill bill : library.getBills().values()) {
            if (bill.getNameReader().equals(reader.getName())) {
                System.out.println("Date: " + bill.getDate());
                for (Book book : reader.getBooks().values()) {
                    System.out.println(calculateFine(book) + "₺ for " + book.getName());
                }
                System.out.println("Total: " + bill.getFine());
            }
        }
    }
    @Override
    public void editBook(Book book, String author, String name, double price, String releaseYear, int pages, String summary) {
        if (searchBook(book.getName())) {
            book.setAuthor(author);
            book.setName(name);
            book.setPrice(price);
            book.setReleaseYear(releaseYear);
            book.setPages(pages);
            book.setSummary(summary);
        } else {
            System.out.println("This book is not in library. So, you can not edit this book");
        }
    }
}
