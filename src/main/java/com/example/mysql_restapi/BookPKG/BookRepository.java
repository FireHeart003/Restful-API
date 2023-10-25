package com.example.mysql_restapi.BookPKG;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository
        extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.ISBN = ?1")
    Optional<Book> FindBookByISBN(long isbn);

    List<Book> findByGenre(String genre);
    List<Book> findTop10ByOrderBySalesDesc();
    List<Book> findByRatingsGreaterThanEqual(double rating);
    List<Book> findByPublisher(String publisher);

}
