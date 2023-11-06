package com.example.mysql_restapi.author;

import com.example.mysql_restapi.book.Book;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String biography;
    private String publisher;
    @SequenceGenerator(
            name = "library_sequence",
            sequenceName = "library_sequence",
            allocationSize = 1
    )

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    public Author(){
    }

    public Author(long id, String name, String biography, String publisher) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.publisher = publisher;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public long getID() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
