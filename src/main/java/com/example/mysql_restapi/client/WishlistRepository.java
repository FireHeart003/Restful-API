package com.example.mysql_restapi.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findAllByClient_Id(Long clientId);
    //I need to add Query methods
}
