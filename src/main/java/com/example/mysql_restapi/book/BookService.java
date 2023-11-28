package com.example.mysql_restapi.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

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

    public Book retrieveBookByTitle(String title) {
        Optional<Book> bookOptional = bookRepository.findByTitle(title);
        return bookOptional.orElseThrow(() -> new IllegalStateException("ISBN not found"));
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findByTitle(book.getTitle());
        if (bookOptional.isPresent()) {
            throw new IllegalStateException("Book with the same ISBN already exists.");
        }
        bookRepository.save(book);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByRating(double rating) {
        return bookRepository.findByRatingsGreaterThanOrEqual(rating);
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
    public Map<String, List<Double>> discountBooksByPublisher(String publisher, double discountPercentage) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        Map<String, List<Double>> priceChanges = new HashMap<>();

        // List to store prices before the update
        List<Double> originalPrices = books.stream().map(Book::getPrice).collect(Collectors.toList());

        for (Book book : books) {
            double currentPrice = book.getPrice();
            double discountedPrice = currentPrice - (currentPrice * discountPercentage / 100.0);

            // Use BigDecimal for rounding to two decimal places
            BigDecimal roundedDiscountedPrice = BigDecimal.valueOf(discountedPrice)
                    .setScale(2, RoundingMode.HALF_UP);

            double finalDiscountedPrice = roundedDiscountedPrice.doubleValue();

            // Update the discountPercentage field in the Book entity
            book.setDiscountPercentage(discountPercentage);

            // Update the price field in the Book entity
            book.setPrice(finalDiscountedPrice);

            bookRepository.save(book);
        }

        // List to store prices after the update
        List<Double> updatedPrices = books.stream().map(Book::getPrice).collect(Collectors.toList());

        // Populate the map with the original and updated prices
        priceChanges.put("originalPrices", originalPrices);
        priceChanges.put("updatedPrices", updatedPrices);

        return priceChanges;
    }


}


