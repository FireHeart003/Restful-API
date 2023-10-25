package com.example.mysql_restapi.BookInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class BookController {

    private final BookOrder bookOrder;

    @Autowired
    public BookController(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }

    @GetMapping(value = "/byGenre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookOrder.getBooksByGenre(genre);
    }

    @GetMapping(value = "/topSellers")
    public List<Book> getTopSellers() {
        return bookOrder.getTopSellers();
    }

    @GetMapping(value = "/byRating/{rating}")
    public List<Book> getBooksByRating(@PathVariable double rating) {
        return bookOrder.getBooksByRating(rating);
    }

    @PatchMapping(value = "/discount/{publisher}")
    public void discountBooksByPublisher(
            @PathVariable String publisher,
            @RequestParam("discountPercentage") double discountPercentage) {
        bookOrder.discountBooksByPublisher(publisher, discountPercentage);
    }
}
