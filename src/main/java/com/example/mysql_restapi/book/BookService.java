package com.example.mysql_restapi.book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {this.bookRepository = bookRepository;}
    public List<Book> getBook(){ return bookRepository.findAll();}


    public Book retrieveBookByISBN(long isbn) {
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        return bookOptional.orElseThrow(() -> new IllegalStateException("ISBN not found"));
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional =
                bookRepository.FindBookByISBN(book.getISBN());
        if(bookOptional.isPresent()){
            throw new IllegalStateException("Book exists already.");
        }
        bookRepository.save(book);

    }

    public  List<Book> getBooksByAuthorId (Long authorId){
        return bookRepository.findByAuthorId(authorId);
    }


    //BROWSING AND SORTING
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
    public List<Book> getBooksByRating(double rating) {
        return bookRepository.findByRatesGreaterThanEqual(rating);
    }
    public List<Integer> getTopSellers() {
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
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
