package com.example.mysql_restapi.comment;
import com.example.mysql_restapi.book.Book;
import com.example.mysql_restapi.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBookISBN(Long bookISBN);
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Comment c WHERE c.client.id = :clientId AND c.book.ISBN = :bookISBN")
    boolean existsByClientAndBook(@Param("clientId") Long clientId, @Param("bookISBN") Long bookISBN);
    //boolean existsByClientAndBook(Long clientId, Long bookISBN);
}