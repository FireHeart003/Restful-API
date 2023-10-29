package com.example.mysql_restapi.BookInventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner bookCommandLineRunner(BookRepository repository){
        return args -> {
            Book book1 = new Book("Team 5", "Horror", 4.5, 100, 10.0);
            Book book2 = new Book("High 5", "Fiction", 4.2, 150, 15.0);
            Book book3 = new Book("Team 5", "Horror", 2.0, 55, 50.0);
            Book book4 = new Book("Team 5", "Mystery", 4.9, 200, 25.0);
            Book book5 = new Book("Low 5", "Romance", 4.7, 175, 20.0);
            Book book6 = new Book("Team 5", "Horror", 3.5, 250, 10.0);
            Book book7 = new Book("High 5", "Fiction", 3.0, 75, 50.0);
            Book book8 = new Book("Low 5", "Mystery", 1.5, 50, 75.0);
            Book book9 = new Book("Low 5", "Romance", 2.5, 110, 15.0);
            Book book10 = new Book("High 5", "Fiction", 5.0, 350, 05.0);

            repository.saveAll(
                    List.of(book1,book2,book3,book4,book5,book6,book7,book8,book9,book10)
            );
        };
    }
}
