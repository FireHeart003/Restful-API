package com.example.mysql_restapi.BookInventory;

import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id

    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String publisher;
    private String genre;
    private double ratings;
    private int sales;
    private double discountPercentage;
    private double price;

    public Book(String pub, String g, double r, int s, double d){
    }

    public Book(String publisher, String genre, double ratings, int sales, double discountPercentage, int price
    ) {
        this.publisher = publisher;
        this.genre = genre;
        this.ratings = ratings;
        this.sales= sales;
        this.discountPercentage=discountPercentage;
        this.price=price;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", ratings='" + ratings + '\'' +
                ", sales='" + sales + '\'' +
                ", discountPercentage='" + discountPercentage + '\'' +
                '}';
    }
}
