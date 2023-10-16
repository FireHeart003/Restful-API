package com.example.mysql_restapi.BookPKG;
import jakarta.persistence.*;

@Entity
@Table
public class Book
{
    @Id
    private long ISBN;
    private String Title;
    private String Description;
    private String Author;
    private String Genre;
    private String Publisher;

    private double Price;
    private int YearPublished;
    private int CopiesSold;

    public Book(long ISBN, String Title, String Description, String Author,
                     String Genre, String Publisher, double Price,
                     int YearPublished, int CopiesSold) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.Description = Description;
        this.Author = Author;
        this.Genre = Genre;
        this.Publisher = Publisher;
        this.Price = Price;
        this.YearPublished = YearPublished;
        this.CopiesSold = CopiesSold;
    }

    public Book() {

    }

    public long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getAuthor() {
        return Author;
    }

    public String getGenre() {
        return Genre;
    }

    public String getPublisher() {
        return Publisher;
    }

    public double getPrice() {
        return Price;
    }

    public int getYearPublished() {
        return YearPublished;
    }

    public int getCopiesSold() {
        return CopiesSold;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setYearPublished(int yearPublished) {
        YearPublished = yearPublished;
    }

    public void setCopiesSold(int copiesSold) {
        CopiesSold = copiesSold;
    }




}
