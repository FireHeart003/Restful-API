package com.example.mysql_restapi.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfiguration {
    @Bean
    CommandLineRunner commandLine(BookRepository repository) {
        return args -> {
            List<Book> sampleBooks = List.of(
                    new Book(
                            987654321,
                            "TestTitle",
                            "This a test object",
                            "Matt",
                            "fiction",
                            "Intellj",
                            15,
                            50,
                            2000,
                            500,
                            0.10
                    ),
                    new Book(
                            987123321,
                            "Skywalker",
                            "Starwars Ep 1",
                            "Geroge Lucas",
                            "Science fiction",
                            "LucasFilm",
                            15,
                            8.8,
                            2000,
                            200,
                            0.10
                    ),
                    new Book(
                            8675309,
                            "The Shining",
                            "Horror best Seller",
                            "Stephen King",
                            "Horror",
                            "Double Day",
                            20,
                            9.5,
                            1977,
                            300,
                            0.25
                    ),
                    new Book(
                            987612345,
                            "Lord of the Flies",
                            " Classic Fiction Novel",
                            "William Goldberg",
                            "Fiction",
                            "Faber and Faber",
                            15.99,
                            7.6,
                            1954,
                            150,
                            0.50
                    ),
                    new Book(
                            527846126,
                            "To Kill a Mockingbird",
                            "Ahead of its time",
                            "Harper Lee",
                            "Fiction",
                            "Lippincott and Company",
                            10.99,
                            8.74,
                            1960,
                            159,
                            0.40
                    ),
                    new Book (
                            921465513,
                            "The Fault in Our Stars",
                            "Will make you rethink love",
                            "John Green",
                            "Romance",
                            "Penguin Young Readers Group",
                            8.99,
                            6.85,
                            2014,
                            310,
                            0.30
                    ),
                    new Book (
                            1489256442,
                            "The Bad Beginning",
                            "The first novel of the popular series",
                            "Lemoney Snicket",
                            "Mystery",
                            "HarperCollins",
                            7.99,
                            8.25,
                            1999,
                            267,
                            0.60
                    ),
                    new Book (
                            516846517,
                            "The Diary of a Young Girl",
                            "Personal story of real life horrors",
                            "Anne Frank",
                            "Biography",
                            "Contact Publishing",
                            12.99,
                            7.35,
                            1947,
                            248,
                            0.25
                    ),
                    new Book (
                            658484541,
                            "The Book Thief",
                            "Another Look into Historical Fiction",
                            "Markus Zusak",
                            "Fiction",
                            "Knopf Books for Young Readers",
                            7.50,
                            8.4,
                            2006,
                            279,
                            0.75
                    ),
                    new Book (
                            351988451,
                            "1984",
                            "Big Brother is watching",
                            "George Orwell",
                            "Fiction",
                            "Secker & Warburg",
                            15.99,
                            8.8,
                            1949,
                            389,
                            0.15
                    )
            );
            repository.saveAll(sampleBooks);
        };
    }
}
