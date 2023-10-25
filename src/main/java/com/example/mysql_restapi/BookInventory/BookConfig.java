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
            Book book1 = new Book("Publisher A", "Genre 1", 4.5, 100, 10.0);
            Book book2 = new Book("Publisher B", "Genre 2", 4.2, 150, 15.0);
            // Add more books as needed

            repository.saveAll(
                    List.of(book1, book2)
            );
        };
    }
}
