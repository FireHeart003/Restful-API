package com.example.mysql_restapi.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;


@RestController
@RequestMapping(path = "api")
public class BookController {
    private final BookService bookService;


    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(value = "/books/{title}")
    public Book retrieveBookByTitle(@PathVariable String title) {
        return bookService.retrieveBookByTitle(title);
    }

    @PostMapping(value = "/books/add")
    public void addNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    //BROWSING AND SORTING
    @GetMapping(value = "/books/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping(value = "/books/topSellers")
    public List<TopSeller> getTopSellers() {
        return bookService.getTopSellers();
    }


    @GetMapping(value = "/books/byRating/{rating}")
    public List<Book> getBooksByRating(@PathVariable double rating) {
        return bookService.getBooksByRating(rating);
    }

    @PutMapping(value = "/books/discount/{publisher}")
    public ResponseEntity<Map<String, List<Double>>> discountBooksByPublisher(
            @PathVariable String publisher,
            @RequestParam("discountPercentage") double discountPercentage) {
        Map<String, List<Double>> priceChanges = bookService.discountBooksByPublisher(publisher, discountPercentage);
        return ResponseEntity.<Map<String, List<Double>>>ok(priceChanges);
    }
}




