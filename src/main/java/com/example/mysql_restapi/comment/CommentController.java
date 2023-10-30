package com.example.mysql_restapi.comment;

import com.example.mysql_restapi.book.Book;
import com.example.mysql_restapi.book.BookRepository;
import com.example.mysql_restapi.client.Client;
import com.example.mysql_restapi.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    private ClientRepository clientRepo;
    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private CommentRepository commentRepo;

    @PostMapping(value = "/createcomment")
    public ResponseEntity<?> createComment(@RequestParam Long clientId, @RequestParam long bookISBN, @RequestParam String commentText) {
        if (commentText == null || commentText.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Comment text cannot be empty.");
        }
        Optional<Client> optionalUser = clientRepo.findById(clientId);
        Optional<Book> optionalBook = bookRepo.findById(bookISBN);

        if (optionalUser.isPresent() && optionalBook.isPresent()) {
            Client client = optionalUser.get();
            Book book = optionalBook.get();
            boolean hasCommented = commentRepo.existsByClientAndBook(clientId, bookISBN);

            if (hasCommented) {
                return ResponseEntity.badRequest().body("You have already left a comment for this book.");
            }

            Comment comment = new Comment();
            comment.setClient(client);
            comment.setBook(book);
            comment.setText(commentText);
            comment.setDatestamp(LocalDateTime.now().toString());

            commentRepo.save(comment);

            return ResponseEntity.ok("Comment created successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or Book not found");
        }
    }
    @GetMapping(value = "/comments/{bookISBN}")
    public List<Comment> getCommentsByBookISBN(@PathVariable long bookISBN){
        return commentRepo.findByBookISBN(bookISBN);
    }

}