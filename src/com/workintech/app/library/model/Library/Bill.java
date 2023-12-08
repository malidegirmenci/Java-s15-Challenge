package com.workintech.app.library.model.Library;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;

public class Bill implements Comparable<Bill> {
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

    @Override
    public String toString() {
        return "-->Bill<--" +
                "\nDate: " + date +
                "\nFine: " + fine +
                "\nReader: " + nameReader;
    }

    @Override
    public int compareTo(Bill bill) {
        Collator collator = Collator.getInstance(new Locale("tr", "TR"));
        int nameComparison = collator.compare(this.nameReader, bill.nameReader);
        if (bill.date.isEqual(this.date)) {
            return nameComparison;
        }
        return bill.date.compareTo(this.date);
    }

}
