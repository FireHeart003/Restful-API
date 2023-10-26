package com.example.mysql_restapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/users")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping(value = "/users/{username}")
    public Client retrieveClientByUsername(@PathVariable String username){return clientService.retrieveClientByUsername(username);}

    @PostMapping(value = "/user/add")
    public void registerNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

    @DeleteMapping(path = "/user/delete/{clientID}")
    public void deleteClient(@PathVariable("clientID") Long clientId){
        clientService.deleteCLient(clientId);
    }

    @PutMapping(path = "/user/update/{clientId}")
    public void updateClient(
            @PathVariable("clientId") Long clientID,
            @RequestBody Client client){

        clientService.updateClient(client.getId(),client);
    }
}
