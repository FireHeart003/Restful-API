package com.example.mysql_restapi.client;


import com.example.mysql_restapi.book.Book;
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

    public void createWishlist(Long clientId, String wishlistName) {
        Client client = new Client();
        client.setId(clientId);

        Wishlist wishlist = new Wishlist();
        wishlist.setName(wishlistName);
        wishlist.setClient(client);

        wishlistRepository.save(wishlist);
    }
//
//    public Wishlist getWishlist(Long wishlistId) {
//        return wishlistRepository.findById(wishlistId)
//                .orElseThrow(() -> new IllegalStateException("Wishlist not found"));
//    }

    public void addBookToWishlist(Long wishlistId, Book book) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new IllegalStateException("Wishlist not found"));

        List<Book> books = wishlist.getBooks();
        books.add(book);
        wishlist.setBooks(books);

        wishlistRepository.save(wishlist);
    }

    public void removeBookFromWishlist(Long wishlistId, Book book) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new IllegalStateException("Wishlist not found"));

        List<Book> books = wishlist.getBooks();
        books.remove(book);
        wishlist.setBooks(books);

        wishlistRepository.save(wishlist);
    }

    public List<Book> getBooksInWishlist(Long wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new IllegalStateException("Wishlist not found"));

        return wishlist.getBooks();
    }
}

