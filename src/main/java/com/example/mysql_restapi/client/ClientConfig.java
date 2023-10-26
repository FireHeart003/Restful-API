package com.example.mysql_restapi.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client hello = new Client(
                    1L,
                    "hello",
                    "world"
            );

            Client fire = new Client(
                    2L,
                    "fire",
                    "water",
                    "John Doe",
                    "fire@gmail.com"
            );

            repository.saveAll(
                    List.of(hello, fire)
            );
        };
    }
}

