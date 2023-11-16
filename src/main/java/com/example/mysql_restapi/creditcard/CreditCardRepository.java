package com.example.mysql_restapi.creditcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    @Query("SELECT c FROM CreditCard c WHERE c.ccnum = ?1")
    Optional<CreditCard> findCreditCardByCcnum(String ccnum);
}