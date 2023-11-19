package com.example.mysql_restapi.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository
        extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.Title = ?1")
    Optional<Book> findByTitle(String title);
    @Query("SELECT b FROM Book b WHERE b.Genre = ?1")
    List<Book> findByGenre(String genre);
    @Query("SELECT new com.example.mysql_restapi.book.TopSeller(b.Title, b.CopiesSold) " +
            "FROM Book b ORDER BY b.CopiesSold DESC")
    List<TopSeller> findTop10ByOrderByCopiesSoldDesc();

    @Query("SELECT b FROM Book b WHERE b.ratings >= :rating")
    List<Book> findByRatingsGreaterThanOrEqual(@Param("rating") double rating);
    @Query("SELECT b FROM Book b WHERE b.Publisher = ?1")
    List<Book> findByPublisher(String publisher);

}

