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
            Client c1 = new Client(
                    1L,
                    "hello",
                    "world",
                    "Jonathan Park",
                    "officialJohn@hotmail.net",
                    "151 Blue Park Avenue"
            );

            Client c2 = new Client(
                    2L,
                    "fire",
                    "water",
                    "John Doe",
                    "fire@gmail.com",
                    "189 London Blvd"
            );

            Client c3 = new Client(
                    3L,
                    "bestuser",
                    "bestuser123",
                     "Paul",
                    "p020@yahoo.net",
                    "Miami-Dade Public Library"
            );
            Client c4 = new Client(
                    4L,
                    "lukaluka",
                    "lukaslukas",
                    "Lukas",
                    "Luka515@gmail.com",
                    "Florida International University"
            );
            Client c5 = new Client(
                    5L,
                    "tonyT",
                    "realTony",
                    "Tony",
                    "officialTony@yahoo.net",
                    "2005 Nw 5th Ave"
            );

            repository.saveAll(
                    List.of(c1, c2, c3, c4, c5)
            );
        };
    }
}

