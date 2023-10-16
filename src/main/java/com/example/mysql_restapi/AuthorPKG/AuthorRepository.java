package com.example.mysql_restapi.AuthorPKG;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository
        extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE a.id = ?1")
    Optional<Author> findAuthorByID(long id);

}
