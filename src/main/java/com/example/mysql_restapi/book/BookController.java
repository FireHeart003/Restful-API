package com.example.mysql_restapi.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api")
public class BookController {
    private final BookService bookService;
    //BOOK DETAILS
    @Autowired
    public BookController(BookService bookService){this.bookService = bookService;}

    @GetMapping(value = "/books")
    public List<Book> getBook(){return bookService.getBook();}

    @GetMapping(value = "/books/{ISBN}")
    public Book retrieveBookByISBN(@PathVariable long ISBN){return bookService.retrieveBookByISBN(ISBN);}

    @PostMapping(value = "/books/add")
    public void addNewBook(@RequestBody Book book){bookService.addNewBook(book);}

    @GetMapping(value = "/books/author/{AuthorID}")
    public List<Book> retrieveBookByAuthorID(@PathVariable long AuthorID){return bookService.retrieveBookByAuthorID(AuthorID);}

    //BROWSING AND SORTING
    @GetMapping(value = "/books/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping(value = "/books/topSellers")
    public List<Integer> getTopSellers() {
        return bookService.getTopSellers();
    }

    @GetMapping(value = "/books/byRating/{rating}")
    public List<Book> getBooksByRating(@PathVariable double rating) {
        return bookService.getBooksByRating(rating);
    }

    @PutMapping(value = "/books/discount/{publisher}")
    public void discountBooksByPublisher(
            @PathVariable String publisher,
            @RequestParam("discountPercentage") double discountPercentage) {
        bookService.discountBooksByPublisher(publisher, discountPercentage);
    }


}
