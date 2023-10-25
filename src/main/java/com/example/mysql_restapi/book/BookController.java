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

    //BROWSING AND SORTING
    @GetMapping(value = "/books/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }
//
//    @GetMapping(value = "/books/topSellers")
//    public List<Book> getTopSellers() {
//        return bookService.getTopSellers();
//    }
//
//    @GetMapping(value = "/books/byRating/{rating}")
//    public List<Book> getBooksByRating(@PathVariable double rating) {
//        return bookService.getBooksByRating(rating);
//    }
//
//    @PutMapping(value = "/books/discount/{publisher}")
//    public void discountBooksByPublisher(
//            @PathVariable String publisher,
//            @RequestParam("discountPercentage") double discountPercentage) {
//        bookService.discountBooksByPublisher(publisher, discountPercentage);
//    }

    //Rating and Commenting
    /*
    @PutMapping(value = "updatebook/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook = bookRepo.findById(id).get();
        updatedBook.setName(book.getName());
        updatedBook.setAuthor(book.getAuthor());
        bookRepo.save(updatedBook);
        return "Updated";
    }

    @DeleteMapping(value = "/deletebook/{id}")
    public String deleteBook(@PathVariable Long id){
        Book deleteBook = bookRepo.findById(id).get();
        bookRepo.delete(deleteBook);
        return "Deleted book with id " + id;
    }
     */


}
