package com.example.mysql_restapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Wishlist> getWishlist(Long clientId) {
        return wishlistRepository.findAllByClient_Id(clientId);
    }

    public void addToWishlist(Long clientId, String bookTitle) {
        Client client = new Client();
        client.setId(clientId);

        Wishlist wishlist = new Wishlist(bookTitle, client);
        wishlistRepository.save(wishlist);
    }

    public void removeFromWishlist(Long wishlistId) {
        wishlistRepository.deleteById(wishlistId);
    }
}
