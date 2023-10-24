package com.example.mysql_restapi.BookPKG;
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


    public Book retrieveBookByISBN(long isbn)
    {
        Optional<Book> bookOptional =
                bookRepository.FindBookByISBN(isbn);
        if (bookOptional.isEmpty()){
            throw new IllegalStateException("ISBN not found");
        }
        Book retrieve = null;
        List<Book> b = bookRepository.findAll();
        for (int i=0; i<b.size();i++){
            Book temp = b.get(i);

            if (temp.getISBN() == isbn)
            {
                retrieve = temp;
            }
        }
        return retrieve;
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional =
                bookRepository.FindBookByISBN(book.getISBN());
        if(bookOptional.isPresent()){
            throw new IllegalStateException("Book exists already.");
        }
        bookRepository.save(book);
    }





}
