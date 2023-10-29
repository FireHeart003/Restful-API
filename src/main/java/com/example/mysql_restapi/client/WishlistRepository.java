package com.example.mysql_restapi.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findAllByClient_Id(Long clientId);
    @Query("SELECT w FROM Wishlist w WHERE w.id = ?1")
    Optional<Wishlist> findWishlistById(Long wishlistId);
    //I Think I added the new query methods
}

