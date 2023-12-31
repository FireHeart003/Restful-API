package com.example.mysql_restapi.rating;

import com.example.mysql_restapi.book.Book;
import com.example.mysql_restapi.book.BookRepository;
import com.example.mysql_restapi.client.Client;
import com.example.mysql_restapi.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class RatingController {
    //ratings
    @Autowired
    private ClientRepository clientRepo;
    @Autowired
    private RatingRepository ratingRepo;
    @Autowired
    private BookRepository bookRepo;

    @GetMapping(value = "/averagerating/{bookISBN}")
    public double getAverageRatingByBookId(@PathVariable Long bookISBN){
        return ratingRepo.findAverageRatingByBookISBN(bookISBN);
    }

    @PostMapping(value = "/createrating")
    public ResponseEntity<?> createRating(@RequestParam Long clientId, @RequestParam Long bookISBN, @RequestParam double ratingValue){
        if(ratingValue < 1 || ratingValue > 5){
            return ResponseEntity.badRequest().body("Invalid rating value. Must be between 1 and 5.");
        }
        Optional<Client> optionalUser = clientRepo.findById(clientId);
        Optional<Book> optionalBook = bookRepo.findById(bookISBN);

        if (optionalUser.isPresent() && optionalBook.isPresent()) {
            Client client = optionalUser.get();
            Book book = optionalBook.get();

            Rating rating = new Rating();
            rating.setClient(client);
            rating.setBook(book);
            rating.setValue(ratingValue);
            rating.setDatestamp(LocalDateTime.now().toString());

            ratingRepo.save(rating);

            return ResponseEntity.ok("Rating created successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or Book not found");
        }

    }
}