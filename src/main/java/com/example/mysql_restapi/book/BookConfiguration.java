package com.example.mysql_restapi.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.util.List;

@Configuration
public class BookConfiguration {
    @Bean
    CommandLineRunner commandLine(BookRepository repository) {
        return args -> {
            List<Book> sampleBooks = List.of(
                    new Book(

                            "TestTitle",
                            "This a test object",
                            "Matt",
                            "fiction",
                            "Intellj",
                            15,
                            50,
                            2000,
                            500,
                            0.10,
                            123456789
                    ),
                    new Book(

                            "Skywalker",
                            "Starwars Ep 1",
                            "Geroge Lucas",
                            "Science fiction",
                            "LucasFilm",
                            15,
                            8.8,
                            2000,
                            200,
                            0.10,
                            987654321
                    ),
                    new Book(

                            "The Shining",
                            "Horror best Seller",
                            "Stephen King",
                            "Horror",
                            "Double Day",
                            20,
                            9.5,
                            1977,
                            300,
                            0.25,
                            987651234
                    ),
                    new Book(

                            "Lord of the Flies",
                            " Classic Fiction Novel",
                            "William Goldberg",
                            "Fiction",
                            "Faber and Faber",
                            15.99,
                            7.6,
                            1954,
                            150,
                            0.50,
                            123498765
                    ),
                    new Book(

                            "To Kill a Mockingbird",
                            "Ahead of its time",
                            "Harper Lee",
                            "Fiction",
                            "Lippincott and Company",
                            10.99,
                            8.74,
                            1960,
                            159,
                            0.40,
                            8675309
                    ),
                    new Book (

                            "The Fault in Our Stars",
                            "Will make you rethink love",
                            "John Green",
                            "Romance",
                            "Penguin Young Readers Group",
                            8.99,
                            6.85,
                            2014,
                            310,
                            0.30,
                            6516854
                    ),
                    new Book (

                            "The Bad Beginning",
                            "The first novel of the popular series",
                            "Lemoney Snicket",
                            "Mystery",
                            "HarperCollins",
                            7.99,
                            8.25,
                            1999,
                            267,
                            0.60,
                            646846545
                    ),
                    new Book (

                            "The Diary of a Young Girl",
                            "Personal story of real life horrors",
                            "Anne Frank",
                            "Biography",
                            "Contact Publishing",
                            12.99,
                            7.35,
                            1947,
                            248,
                            0.25,
                            51846548

                    ),
                    new Book (

                            "The Book Thief",
                            "Another Look into Historical Fiction",
                            "Markus Zusak",
                            "Fiction",
                            "Knopf Books for Young Readers",
                            7.50,
                            8.4,
                            2006,
                            279,
                            0.75,
                            57418464
                    ),
                    new Book (

                            "1984",
                            "Big Brother is watching",
                            "George Orwell",
                            "Fiction",
                            "Secker & Warburg",
                            15.99,
                            8.8,
                            1949,
                            389,
                            0.15,
                            84516451
                    )
            );
            repository.saveAll(sampleBooks);
        };
    }
}

