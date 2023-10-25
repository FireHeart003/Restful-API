package com.example.mysql_restapi.BookInventory;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOrder {
    private final BookRepository bookRepository;

    @Autowired
    public BookOrder(BookRepository bookRepository){
        this.bookRepository = bookRepository;
}
    public List<Book> getBooksByGenre(String genre) {
    return bookRepository.findByGenre(genre);
}
    public List<Book> getBooksByRating(double rating) {
        return bookRepository.findByRatingsGreaterThanEqual(rating);
    }
    public List<Book> getTopSellers() {
        return bookRepository.findTop10ByOrderBySalesDesc();
    }
    @Transactional
    public void discountBooksByPublisher(String publisher, double discountPercentage) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        for (Book book : books) {
            double currentPrice = book.getPrice(); // You need to have a price attribute in your Book entity
            double discountedPrice = currentPrice * (1.0 - discountPercentage / 100.0);
            book.setPrice(discountedPrice);
            bookRepository.save(book);
        }
    }


}