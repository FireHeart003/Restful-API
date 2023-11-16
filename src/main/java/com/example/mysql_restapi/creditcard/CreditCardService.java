package com.example.mysql_restapi.creditcard;

import com.example.mysql_restapi.client.Client;
import com.example.mysql_restapi.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    private final CreditCardRepository cardRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public CreditCardService(CreditCardRepository cardRepository){
        this.cardRepository = cardRepository;
    }
    public List<CreditCard> getCards() {
        return cardRepository.findAll();
    }

    public void addNewCard(String username, CreditCard card) {
        Optional<Client> clientOptional = clientRepository.findClientByUsername(username);
        if(clientOptional.isEmpty()){
            throw new IllegalStateException("User not found");
        }
        else{
            Client c = clientOptional.get();
            c.setCard(card);
            cardRepository.save(card);
        }
    }
}
