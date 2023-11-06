package com.example.mysql_restapi.client;
import com.example.mysql_restapi.book.Book;


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

//    @PostMapping(value = "/wishlist")
//    public Wishlist getWishlist(@RequestParam Long wishlistId) {
//        return wishlistService.getWishlist(wishlistId);
//    }

    @PostMapping(value = "/create")
    public String createWishlist(@RequestParam Long clientId, @RequestParam String wishlistName) {
        wishlistService.createWishlist(clientId, wishlistName);
        return "Wishlist created successfully!";
    }

    @PostMapping(value = "/addBook")
    public void addBookToWishlist(@RequestParam Long wishlistId, @RequestBody Book book) {
        wishlistService.addBookToWishlist(wishlistId, book);
    }

    @DeleteMapping(value = "/removeBook")
    public void removeBookFromWishlist(@RequestParam Long wishlistId, @RequestBody Book book) {
        wishlistService.removeBookFromWishlist(wishlistId, book);
    }

    @GetMapping(value = "/getBooks")
    public List<Book> getBooksInWishlist(@RequestParam Long wishlistId) {
        return wishlistService.getBooksInWishlist(wishlistId);
    }
}

