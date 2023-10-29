package com.example.mysql_restapi.creditcard;

import com.example.mysql_restapi.client.Client;
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
        cardService.addNewCard(username, card);
    }
}
