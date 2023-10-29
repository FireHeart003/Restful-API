package com.example.mysql_restapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping(value = "/{clientId}")
    public List<Wishlist> getWishlist(@PathVariable("clientId") Long clientId) {
        return wishlistService.getWishlist(clientId);
    }

    @PostMapping(value = "/add")
    public void addToWishlist(
            @RequestParam("clientId") Long clientId,
            @RequestParam("bookTitle") String bookTitle) {
        wishlistService.addToWishlist(clientId, bookTitle);
    }

    @DeleteMapping(path = "/remove/{wishlistId}")
    public void removeFromWishlist(@PathVariable("wishlistId") Long wishlistId) {
        wishlistService.removeFromWishlist(wishlistId);
    }
    @PutMapping(path = "/wishlist/updateName/{wishlistId}")
    public void updateWishlistName(
            @PathVariable("wishlistId") Long wishlistId,
            @RequestParam("wishlistName") String wishlistName) {
        wishlistService.updateWishlistName(wishlistId, wishlistName);
    }
    @GetMapping(value = "/wishlist/{wishlistId}")
    public Wishlist getWishlistById(@PathVariable("wishlistId") Long wishlistId) {
        return wishlistService.getWishlistById(wishlistId);
    }

}
