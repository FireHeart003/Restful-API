package com.example.mysql_restapi.BookInventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository
        extends JpaRepository<Book, Long> {

    List<Book> findByGenre(String genre);
    List<Book> findTop10ByOrderBySalesDesc();
    List<Book> findByRatingsGreaterThanEqual(double rating);
    List<Book> findByPublisher(String publisher);

}
