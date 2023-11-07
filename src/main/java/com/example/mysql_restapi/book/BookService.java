package com.example.mysql_restapi.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;
package com.example.mysql_restapi.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book retrieveBookByISBN(long isbn) {
        Optional<Book> bookOptional = bookRepository.findByISBN(isbn);
        if (bookOptional.isEmpty()) {
            throw new IllegalStateException("ISBN not found");
        }
        return bookOptional.get();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findByISBN(book.getISBN());
        if (bookOptional.isPresent()) {
            throw new IllegalStateException("Book with the same ISBN already exists.");
        }
        bookRepository.save(book);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByRating(double rating) {
        return bookRepository.findByRatingsGreaterThanEqual(rating);
    }

    public List<TopSeller> getTopSellers() {
        List<TopSeller> topSellers = bookRepository.findTop10ByOrderByCopiesSoldDesc();
        List<TopSeller> topSellerList = new ArrayList<>();

        for (TopSeller book : topSellers) {
            topSellerList.add(new TopSeller(book.getTitle(), book.getCopiesSold()));
        }

        return topSellerList;
    }


    @Transactional
    public void discountBooksByPublisher(String publisher, double discountPercentage) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        for (Book book : books) {
            double currentPrice = book.getPrice();
            double discountedPrice = currentPrice * (1.0 - discountPercentage / 100.0);
            book.setPrice(discountedPrice);
            bookRepository.save(book);
        }
    }
}
