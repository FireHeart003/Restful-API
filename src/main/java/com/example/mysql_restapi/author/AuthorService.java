package com.example.mysql_restapi.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        Optional<Author> authorOptional =
                authorRepository.findAuthorByID(author.getID());
        if(authorOptional.isPresent()){
            throw new IllegalStateException("Author exists already.");
        }
        authorRepository.save(author);
    }

}
