package com.example.mysql_restapi.client;

import jakarta.persistence.*;

@Entity
@Table
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String wishlistName;
    private String bookTitle;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Wishlist() {
    }


    public Wishlist(String bookTitle, Client client) {
        this.bookTitle = bookTitle;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
}
