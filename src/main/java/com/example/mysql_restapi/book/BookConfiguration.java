package com.example.mysql_restapi.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfiguration {
    @Bean
    CommandLineRunner commandLine(BookRepository repository){
        return args -> {


            Book book1 = new Book(

                    987123321,
                    "Skywalker",
                    "Starwars Ep 1",
                    "Test Author",
                    123456789,
                    "Science fiction",
                    "LucasFilm",
                    15,
                    8.8,
                    2000,
                    200,
                    0.10
            );

            Book book2 = new Book(
                    516202200,
                    "The Great Gatsby",
                    "Test book for Great Gatsby",
                    "Test Author",
                    123456789,
                    "Novel",
                    "Test Publisher",
                    20,
                    9.8,
                    2000,
                    3000,
                    0.0
            );


            repository.saveAll(
                    List.of(book1, book2)
            );
        };
    }
}
