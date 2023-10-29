package com.example.mysql_restapi.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Long> {

    @Query("SELECT s FROM Client s WHERE s.email = ?1")
    Optional<Client> findClientByEmail(String email);

    @Query("SELECT c FROM Client c WHERE c.username = ?1")
    Optional<Client> findClientByUsername(String username);
    @Query("SELECT c FROM Client c WHERE c.id = ?1")
    Optional<Client> findClientById(long id);
}
