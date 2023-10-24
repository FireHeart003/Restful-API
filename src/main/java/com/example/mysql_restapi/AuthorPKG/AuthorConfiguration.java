package com.example.mysql_restapi.AuthorPKG;

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
                    12345678,
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
