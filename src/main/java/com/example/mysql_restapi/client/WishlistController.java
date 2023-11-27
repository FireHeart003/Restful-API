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

    @PostMapping(value = "/create")
    public String createWishlist(@RequestParam Long clientId, @RequestParam String wishlistName) {
        Long generatedWishlistId = wishlistService.createWishlist(clientId, wishlistName);
        return "You have successfully created a Wishlist with name " + wishlistName + "\nThis is your generated Wishlist ID = " + generatedWishlistId;
    }

    @PostMapping(value = "/addBook")
    public String addBookToWishlist(@RequestParam Long clientId, @RequestParam String wishlistName, @RequestParam long ISBN) {
        wishlistService.addBookToWishlist(clientId, wishlistName, ISBN);
        return "You have added a Book successfully!\n" + "Book added to " + wishlistName
                + "\nBook Id " + ISBN;
    }

    @DeleteMapping(value = "/removeBook")
    public String removeBookFromWishlist(@RequestParam Long clientId, @RequestParam String wishlistName, @RequestParam long ISBN) {
        wishlistService.removeBookFromWishlist(clientId, wishlistName, ISBN);
        return "You have deleted a Book successfully!\n" + "Book deleted: " + ISBN;
    }

    @GetMapping(value = "/getBooks")
    public List<Book> getBooksInWishlist(@RequestParam Long clientId, @RequestParam String wishlistName) {
        return wishlistService.getBooksInWishlist(clientId, wishlistName);
        }
    }