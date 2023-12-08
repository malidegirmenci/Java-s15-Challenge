package com.workintech.app.library.model.library;

import com.workintech.app.library.enums.Status;
import com.workintech.app.library.interfaces.Editable;
import com.workintech.app.library.model.books.Book;
import com.workintech.app.library.model.person.Reader;
import com.workintech.app.library.utils.Helper;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public class Librarian implements Editable {
    private final String password;
    private String username;
    private final Library library;

    public Librarian(String name, String password, Library library) {
        this.username = name;
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

    public boolean searchBook(UUID bookID) {
        for (Map.Entry<UUID, Book> bookEntry : library.getBooks().entrySet()) {
            if (bookID.equals(bookEntry.getKey())) {
                return true;
            }
        }
        System.out.println("The book is not register in the system");
        return false;
    }

    public boolean verifyMember(UUID uuid) {
        for (Map.Entry<UUID, Reader> reader : library.getReaders().entrySet()) {
            if (uuid.equals(reader.getKey())) {
                //System.out.println(reader.getValue().getName() + " is in library system");
                return true;
            }
        }
        System.out.println("The member is not in library system");
        return false;
    }

    public void checkDamaged(Book book, @NotNull Status status) {
        if (status.equals(Status.DAMAGED)) {
            book.getOwner().getBooks().get(book.getID()).setStatus(Status.DAMAGED);
            System.out.println("You returned to the book damaged");
        } else {
            System.out.println("Thank you. The book is in good condition. You can deliver the book.");
            book.getOwner().getBooks().get(book.getID()).setStatus(Status.UNDAMAGED);
        }
    }

    public void issueBook(@NotNull Reader reader, Book book, String date) {
        if (verifyMember(reader.getID())) {
            if (reader.getNoBooksIssued() < reader.getMaxBookLimit()) {
                if (book.getStatus().equals(Status.AVAILABLE)) {
                    book.updateStatus(Status.BORROWED);
                    book.setDateOfTaken(Helper.convertLD(date));
                    book.setFinalDeliveryDate(book.getDateOfTaken().plusDays(15));
                    book.setDeadline(book.getDateOfTaken().plusDays(90));
                    book.changeOwner(reader);
                    reader.borrowBook(book);
                    System.out.println(book.getName() + " was borrowed by " + reader.getName());
                } else {
                    System.out.println(book.getName() + " was already borrowed by " + book.getOwner().getName());
                }
            } else {
                System.out.println("You already five books. So you can not take any books");
            }
        } else {
            System.out.println(reader.getName() + " is not registered, You must be registered in system");
        }
    }

    public void returnBook(Reader reader, @NotNull Book book) {
        if (book.getStatus().equals(Status.UNDAMAGED)) {
            if (verifyMember(reader.getID())) {
                if (reader.getBooks().containsKey(book.getID())) {
                    book.updateStatus(Status.AVAILABLE);
                    book.setDateOfTaken(null);
                    book.setFinalDeliveryDate(null);
                    book.setDeadline(null);
                    book.changeOwner(null);
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

    public double calculateFine(@NotNull Book book) {
        LocalDate today = LocalDate.now();
        int penaltyDays;
        double penaltyAmount = 0;
        if (book.getStatus().equals(Status.DAMAGED)) {
            penaltyAmount += book.getPrice();
            System.out.println(
                    book.getOwner().getName() + " delivered the book damaged. So, you must pay " + book.getName() + "'s price");
        }
        if (today.isAfter(book.getFinalDeliveryDate())) {
            if (today.isAfter(book.getDeadline())) {
                penaltyDays = book.getDeadline().until(today).getDays();
                penaltyAmount = (penaltyDays * 1.5) + book.getPrice();
                System.out.println(
                        book.getOwner().getName() + " passed deadline of " + book.getName() + " with " + penaltyDays + " days.");
            } else {
                penaltyDays = book.getFinalDeliveryDate().until(today).getDays();
                penaltyAmount = penaltyDays * 1.5;
                System.out.println(book.getOwner().getName() + " passed final delivery date of " + book.getName() + " with " + penaltyDays + " days.");
            }
        } else {
            System.out.println(book.getOwner().getName() + " don't have penalty for " + book.getName() + ". Thank you!");
        }
        return penaltyAmount;
    }

    public void createBill(@NotNull Reader reader) {
        LocalDate deliveredDate = LocalDate.now();
        double fines = 0;
        for (Book book : reader.getBooks().values()) {
            fines += calculateFine(book);
        }
        Bill bill = new Bill(deliveredDate, fines, reader.getName());
        library.getBills().put(reader.getID(), bill);
    }

    public void showBill(@NotNull Reader reader) {
        System.out.println("----> BILL <----");
        System.out.println("Mr/s " + reader.getName());
        if (searchBill(reader.getID())) {
            Bill bill = getBill(reader.getID());
            if (bill.getFine() == 0) {
                System.out.println("You don't have any fine. So there is no bill");
            } else {
                System.out.println("Date: " + bill.getDate());
                for (Book book : reader.getBooks().values()) {
                    System.out.println(calculateFine(book) + "₺ for " + book.getName());
                }
                System.out.println("Total: " + bill.getFine());
            }
        } else {
            System.out.println("You don't have any bill. Thank you!");
        }
    }

    public boolean searchBill(UUID readerID) {
        return library.getBills().containsKey(readerID);
    }

    public Bill getBill(UUID readerID) {
        return library.getBills().get(readerID);
    }

    @Override
    public void editBook(@NotNull Book book, String author, String name, double price, String releaseYear, int pages, String summary) {
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

    @Override
    public void editReader(@NotNull Reader reader, String name, String dateOfMembership, String address, String phoneNo, String type) {
        if (verifyMember(reader.getID())) {
            reader.setName(name);
            reader.setDateOfMembership(dateOfMembership);
            reader.setAddress(address);
            reader.setPhoneNo(phoneNo);
            reader.setType(type);
        } else {
            System.out.println("This reader is not in system. So, you can not edit this book");
        }
    }
}
