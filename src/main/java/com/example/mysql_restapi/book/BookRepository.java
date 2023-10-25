package com.example.mysql_restapi.book;

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
    @Query("SELECT b FROM Book b WHERE b.Genre = ?1")
    List<Book> findByGenre(String genre);

//    @Query("SELECT b FROM Book b WHERE b.CopiesSold = ?1")
//    List<Book> findTop10ByOrderBySalesDesc();
//
//    @Query("SELECT b FROM Book b WHERE b.ratings = ?1")
//    List<Book> findByRatingsGreaterThanEqual(double rating);
//    @Query("SELECT b FROM Book b WHERE b. = ?1")
//    List<Book> findByPublisher(String publisher);

}
