package com.example.mysql_restapi.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/authors")
    public List<Author> getAuthor(){
        return authorService.getAuthor();
    }

    @GetMapping(value = "/authors/{AuthorID}")
    public Author retrieveAuthorById(@PathVariable long AuthorID){return authorService.retrieveAuthorByID(AuthorID);}

    @PostMapping(value = "/authors/add")
    public void registerNewAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
    }

}
