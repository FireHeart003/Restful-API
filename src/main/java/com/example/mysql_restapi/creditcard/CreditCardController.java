package com.example.mysql_restapi.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class CreditCardController {
    private final CreditCardService cardService;

    @Autowired
    public CreditCardController(CreditCardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(value = "/cards")
    public List<CreditCard> getClients(){
        return cardService.getCards();
    }

    @PostMapping(value = "/add/card")
    public void registerNewCard(@RequestParam String username, @RequestBody CreditCard card){
        System.out.println(card.getYear());
        System.out.println("\n"+ card.getMonth());
        cardService.addNewCard(username, card);
    }
}
