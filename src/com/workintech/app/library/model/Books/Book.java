package com.workintech.app.library.model.Books;

import com.workintech.app.library.enums.Status;
import com.workintech.app.library.model.Person.Person;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public abstract class Book implements Comparable<Book> {
    private final UUID ID;
    private String author;
    private String name;
    private double price;
    private Status status;
    private String releaseYear;
    private int pages;
    private LocalDate dateOfTaken;
    private LocalDate finalDeliveryDate;
    private LocalDate deadline;
    private String summary;
    private Person owner;


    public Book(String author, String name, double price, String releaseYear, int pages, String summary) {
        this.ID = UUID.randomUUID();
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = Status.AVAILABLE;
        this.releaseYear = releaseYear;
        this.pages = pages;
        this.summary = summary;
    }

    public UUID getID() {
        return ID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public LocalDate getDateOfTaken() {
        return dateOfTaken;
    }

    public void setDateOfTaken(LocalDate dateOfTaken) {
        this.dateOfTaken = dateOfTaken;
    }

    public LocalDate getFinalDeliveryDate() {
        return finalDeliveryDate;
    }

    public void setFinalDeliveryDate(LocalDate finalDeliveryDate) {
        this.finalDeliveryDate = finalDeliveryDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void changeOwner(Person owner) {
        setOwner(owner);
    }

    public void updateStatus(Status status) {
        setStatus(status);
    }

    public void display() {
        System.out.println("--> " + getName() + " <--");
        System.out.println(
                "Author : " + getAuthor() +
                        "\nRelease Year: " + getReleaseYear() +
                        "\nPages: " + getPages() +
                        "\nSummary: " + getSummary() +
                        "\nPrice: " + getPrice() + "₺" +
                        "\nStatus: " + getStatus()
        );
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(ID, book.ID);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
    @Override
    public int compareTo(Book book) {
        Collator collator = Collator.getInstance(new Locale("tr", "TR"));
        int nameComparison = collator.compare(this.name, book.name);
        if(nameComparison == 0){
            return collator.compare(author,book.author);
        }
        return nameComparison;
    }
}
