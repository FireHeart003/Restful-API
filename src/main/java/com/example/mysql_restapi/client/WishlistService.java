package com.example.mysql_restapi.client;

import com.example.mysql_restapi.book.BookRepository;
import com.example.mysql_restapi.book.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final BookRepository bookRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, BookRepository bookRepository) {
        this.wishlistRepository = wishlistRepository;
        this.bookRepository = bookRepository;
    }

    public Long createWishlist(Long clientId, String wishlistName) {
        Client client = new Client();
        client.setId(clientId);

        // Check the # of existing wishlists for the user (limit 3)
        List<Wishlist> userWishlists = wishlistRepository.findByClientId(clientId);
        if (userWishlists.size() >= 3) {
            throw new IllegalStateException("You can't create more than 3 wishlists.");
        }

        Wishlist wishlist = new Wishlist();
        wishlist.setName(wishlistName);
        wishlist.setClient(client);

        wishlistRepository.save(wishlist);
        return wishlist.getId();
    }

    public void addBookToWishlist(Long clientId, String wishlistName, long ISBN) {
        Wishlist wishlist = findOrCreateWishlist(clientId, wishlistName);

        Optional<Book> bookOptional = bookRepository.FindBookByISBN(ISBN);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            List<Book> books = wishlist.getBooks();
            books.add(book);
            wishlist.setBooks(books);
            wishlistRepository.save(wishlist);
        } else {
            throw new IllegalStateException("Book with ISBN " + ISBN + " not found");
        }
    }

    public void removeBookFromWishlist(Long clientId, String wishlistName, long ISBN) {
        Wishlist wishlist = findWishlistByNameAndClientId(clientId, wishlistName);

        Optional<Book> bookOptional = bookRepository.FindBookByISBN(ISBN);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            List<Book> books = wishlist.getBooks();
            books.remove(book);
            wishlist.setBooks(books);
            wishlistRepository.save(wishlist);
        } else {
            throw new IllegalStateException("Book with ISBN " + ISBN + " not found");
        }
    }

    public List<Book> getBooksInWishlist(Long clientId, String wishlistName) {
        Wishlist wishlist = findWishlistByNameAndClientId(clientId, wishlistName);

        return wishlist.getBooks();
    }

    private Wishlist findWishlistByNameAndClientId(Long clientId, String wishlistName) {
        return wishlistRepository.findByNameAndClientId(wishlistName, clientId)
                .orElseThrow(() -> new IllegalStateException("Wishlist not found"));
    }

    private Wishlist findOrCreateWishlist(Long clientId, String wishlistName) {
        Optional<Wishlist> wishlistOptional = wishlistRepository.findByNameAndClientId(wishlistName, clientId);
        return wishlistOptional.orElseGet(() -> {
            Wishlist newWishlist = new Wishlist();
            newWishlist.setName(wishlistName);

            Client client = new Client();
            client.setId(clientId);

            newWishlist.setClient(client);

            return wishlistRepository.save(newWishlist);
        });
    }
}
