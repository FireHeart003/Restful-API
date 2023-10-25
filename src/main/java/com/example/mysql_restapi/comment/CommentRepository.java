package com.example.mysql_restapi.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT b FROM Book b WHERE b.ISBN = ?1")
    List<Comment> findByBookId(Long bookId);
}