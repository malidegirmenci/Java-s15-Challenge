package com.workintech.app.library.model.Person;

import com.workintech.app.library.Enums.Roles;
import com.workintech.app.library.Enums.Status;
import com.workintech.app.library.model.Books.Book;


import java.util.UUID;


public abstract class Reader extends Person {
    private final UUID ID;
    private String type;
    private String dateOfMembership;
    private int maxBookLimit;
    private String address;
    private String phoneNo;

    public Reader(String name, String dateOfMembership, String address, String phoneNo) {
        super(name, Roles.READER);
        this.ID = UUID.randomUUID();
        this.type = getClass().getName();
        this.dateOfMembership = dateOfMembership;
        this.address = address;
        this.phoneNo = phoneNo;
        this.maxBookLimit = 5;
    }
    public Reader getMember(){
        return this;
    }
    public void incBookIssued(){
        maxBookLimit -= 1;
    }
    public void decBookIssued(){
        maxBookLimit += 1;
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
    public void addBook(Book book){

        getBooks().put(book.getID(),book);
        book.update_status(Status.BORROWED);
        book.setOwner(this);
    }
}
