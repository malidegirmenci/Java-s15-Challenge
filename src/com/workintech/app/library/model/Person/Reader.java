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
        setMaxBookLimit(getMaxBookLimit()+1);
    }
    public void decBookIssued(){
        setMaxBookLimit(getMaxBookLimit()-1);
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
        decBookIssued();
    }
    @Override
    public void removeBook(Book book){
        getBooks().remove(book.getID());
        incBookIssued();
    }

    @Override
    public void showPerson() {
        System.out.println("-->"+getName()+"<--");
        System.out.println("Role: "+getRole());
        System.out.println("WhatAmI: "+getType());
        System.out.println("Date of Membership: "+getDateOfMembership());
        System.out.println("My Address: "+getAddress());
        System.out.println("My Phone: " +getPhoneNo());
        System.out.println("My Book Limit: "+ getMaxBookLimit());
        System.out.println("--> Books <--");
        int i = 1;
        for(Book book : getBooks().values()){
            System.out.println(i++ +". "+book.getName());
        }
    }
}
