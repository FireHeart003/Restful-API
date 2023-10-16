package com.example.mysql_restapi.BookPKG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){this.bookService = bookService;}

    @GetMapping(value = "/books")
    public List<Book> getBook(){return bookService.getBook();}

    @GetMapping(value = "/{ISBN}")
    public Book retrieveBook(@PathVariable long ISBN){return bookService.retrieveBook(ISBN);}

    @PostMapping(value = "/addBook")
    public void addNewBook(@RequestBody Book book){bookService.addNewBook(book);}
}
