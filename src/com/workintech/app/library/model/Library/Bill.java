package com.workintech.app.library.model.Library;

import com.workintech.app.library.model.Books.Book;

import java.time.LocalDate;

public class Bill {
    private LocalDate date;
    private Double fine;
    private String nameReader;


    public Bill(LocalDate date, Double fine, String nameReader) {
        this.date = date;
        this.fine = fine;
        this.nameReader = nameReader;

    }

    public LocalDate getDate() {
        return date;
    }

    public Double getFine() {
        return fine;
    }

    public String getNameReader() {
        return nameReader;
    }
}
