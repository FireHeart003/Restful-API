    package com.example.mysql_restapi.client;

    import com.example.mysql_restapi.book.Book;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;

    import java.util.List;
    import java.util.Optional;

    @Repository
    public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
        @Query("SELECT w FROM Wishlist w WHERE w.client.id = ?1")
        List<Wishlist> findByClientId(Long clientId);

        @Query("SELECT w FROM Wishlist w WHERE w.name = ?1 AND w.client.id = ?2")
        Optional<Wishlist> findByNameAndClientId(String name, Long clientId);

        @Query("SELECT w FROM Wishlist w WHERE w.client.id = ?1 AND w.books IS EMPTY")
        List<Wishlist> findEmptyWishlistsByClientId(Long clientId);

//        @Query("SELECT w FROM Wishlist w LEFT JOIN FETCH w.books WHERE w.name = ?1")
//        Optional<Wishlist> findByNameWithBooks(String name);
//


    }


