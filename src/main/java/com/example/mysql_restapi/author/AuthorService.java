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
                authorRepository.FindAuthorByID(author.getID());
        if(authorOptional.isPresent()){
            throw new IllegalStateException("Author exists already.");
        }
        authorRepository.save(author);
    }

    public Author retrieveAuthorByID(long id)
    {
        Optional<Author> authorOptional =
                authorRepository.FindAuthorByID(id);
        if (authorOptional.isEmpty()){
            throw new IllegalStateException("Author ID not found");
        }
        Author retrieve = null;
        List<Author> b = authorRepository.findAll();
        for (int i=0; i<b.size();i++){
            Author temp = b.get(i);

            if (temp.getID() == id)
            {
                retrieve = temp;
            }
        }
        return retrieve;
    }
}
