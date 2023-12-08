package com.workintech.app.library.model.person;

import com.workintech.app.library.enums.Roles;
import com.workintech.app.library.interfaces.Borrowable;
import com.workintech.app.library.model.books.Book;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class Reader extends Person implements Borrowable {
    private final UUID ID;
    private String type;
    private String dateOfMembership;
    private int maxBookLimit;
    private int noBooksIssued;
    private String address;
    private String phoneNo;

    public Reader(String name, String dateOfMembership, String address, String phoneNo) {
        super(name, Roles.READER);
        this.ID = UUID.randomUUID();
        this.type = getClass().getSimpleName();
        this.dateOfMembership = dateOfMembership;
        this.address = address;
        this.phoneNo = phoneNo;
        this.maxBookLimit = 5;
        this.noBooksIssued = 0;
    }

    public void incBookIssued() {
        setNoBooksIssued(getNoBooksIssued() + 1);
    }

    public void decBookIssued() {
        setNoBooksIssued(getNoBooksIssued() - 1);
    }

    public UUID getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(String dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public void addBook(Book book) {
        System.out.println("Readers can not add a book");
    }

    @Override
    public void borrowBook(Book book) {
        getBooks().put(book.getID(), book);
        decBookIssued();
    }

    @Override
    public void removeBook(@NotNull Book book) {
        getBooks().remove(book.getID());
        incBookIssued();
    }

    @Override
    public void showPerson() {
        System.out.println("-->" + getName() + "<--" +
        "\nRole: " + getRole() +
        "\nType: " + getType() +
        "\nDate of Membership: " + getDateOfMembership() +
        "\nMy Address: " + getAddress() +
        "\nMy Phone: " + getPhoneNo() +
        "\nMy Issued Book Number: " + getNoBooksIssued() +
        "\n--> Books <--");
        int i = 1;
        for (Book book : getBooks().values()) {
            System.out.println(i++ + ". " + book.getName() + " --> Due Date: " + book.getFinalDeliveryDate().getMonth() + " " + book.getFinalDeliveryDate().getDayOfMonth());
        }
    }
}
