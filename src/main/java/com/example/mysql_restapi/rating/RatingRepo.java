package com.example.mysql_restapi.rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingRepo extends JpaRepository<Rating, Long> {
    @Query("SELECT AVG(r.value) FROM Rating r WHERE r.book.id = :bookId")
    Double findAverageRatingByBookId(Long bookId);
}
