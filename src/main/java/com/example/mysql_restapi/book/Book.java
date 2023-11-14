package com.example.mysql_restapi.book;
import com.example.mysql_restapi.rating.Rating;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Book
{
    @Id
    @Column
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ISBN;

    private String Title;
    private String Description;

    private String Author;
    private long AuthorID;
    private String Genre;
    private String Publisher;

    private double Price;
    private double ratings;
    private double discountPercentage;
    private int YearPublished;
    private int CopiesSold;

    @OneToMany(mappedBy = "book")
    private List<Rating> rates;

//    public Book(long ISBN, String Title, String Description, String Author, long AuthorID,
//                     String Genre, String Publisher, double Price,
//                     int YearPublished, int CopiesSold) {
//        this.ISBN = ISBN;
//        this.Title = Title;
//        this.Description = Description;
//        this.AuthorID = AuthorID;
//        this.Author = Author;
//        this.Genre = Genre;
//        this.Publisher = Publisher;
//        this.Price = Price;
//        this.YearPublished = YearPublished;
//        this.CopiesSold = CopiesSold;
//    }

    public Book(long ISBN, String title, String description, String author, long AuthorId, String genre,
                String publisher, double price, double ratings, int yearPublished, int copiesSold,
                double discountPercentage
                ) {
        this.ISBN = ISBN;
        Title = title;
        Description = description;
        Author = author;
        AuthorID= AuthorId;
        Genre = genre;
        Publisher = publisher;
        Price = price;
        this.ratings = ratings;
        this.discountPercentage = discountPercentage;
        YearPublished = yearPublished;
        CopiesSold = copiesSold;
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

    public long getAuthorID() {return AuthorID;}

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

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
    /*public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }*/

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Author='" + Author + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Price=" + Price +
                ", ratings=" + ratings +
                ", discountPercentage=" + discountPercentage +
                ", YearPublished=" + YearPublished +
                ", CopiesSold=" + CopiesSold +
                '}';
    }
}
