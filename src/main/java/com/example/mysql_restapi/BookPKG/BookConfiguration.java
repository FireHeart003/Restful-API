package com.example.mysql_restapi.BookPKG;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfiguration {
    @Bean
    CommandLineRunner commandLine(BookRepository repository){
        return args -> {
            Book Test = new Book(
                    987654321,
                    "TestTitle",
                    "This a test object",
                    "Matt",
                    "fiction",
                    "Intellj",
                    50,
                    2000,
                    500

            );

            repository.saveAll(
                    List.of(Test)
            );
        };
    }
}
