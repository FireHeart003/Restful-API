package com.example.mysql_restapi.author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AuthorConfiguration {
    @Bean
    CommandLineRunner commandLineRunnerAuthor(AuthorRepository repository){
        return args -> {
            Author FirstTest = new Author(
                    123456789,
                    "Test Author",
                    "This is a test author",
                    "TestPublisher"
            );

            repository.saveAll(
                    List.of(FirstTest)
            );
        };
    }
}
