package com.example.mysql_restapi.AuthorPKG;

import com.example.mysql_restapi.BookPKG.Book;
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

    @GetMapping(value = "/Authors")
    public List<Author> getAuthor(){
        return authorService.getAuthor();
    }

    //@GetMapping(value = "/{AuthorID}")
    //public Author retrieveBookByAuthor(@PathVariable long ID){return authorService.retrieveBookByAuthor(ID);}

    @PostMapping(value = "/AddAuthor")
    public void registerNewAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
    }

}
