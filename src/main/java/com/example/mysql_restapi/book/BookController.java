package com.example.mysql_restapi.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping(value = "/books")
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    @PostMapping(value = "/savebook")
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "Saved";
    }
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

}
