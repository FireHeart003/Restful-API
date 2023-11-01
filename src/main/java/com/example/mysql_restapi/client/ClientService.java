package com.example.mysql_restapi.client;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional =
                clientRepository.findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        clientRepository.save(client);
    }

    public void deleteCLient(Long clientId) {
        boolean exists = clientRepository.existsById((clientId));
        if(!exists){
            throw new IllegalStateException("client with id " + clientId
                    + " does not exists");

        }
        clientRepository.deleteById(clientId);
    }

    @Transactional
    public void updateClient(String username, Client newclient){
        Client client = clientRepository.findClientByUsername(username)
                .orElseThrow(() -> new IllegalStateException((
                        "User with username" + username + " does not exist!"
                )));

        if(newclient.getName() != null &&
                !newclient.getName().isEmpty() &&
                !Objects.equals(client.getName(), newclient.getName())){
            client.setName(newclient.getName());
        }
        if(newclient.getUsername() != null &&
                !newclient.getUsername().isEmpty() &&
                !Objects.equals(client.getUsername(), newclient.getUsername())){
            client.setUsername(newclient.getUsername());
        }
        if(newclient.getEmail().isEmpty()){
            client.setEmail(newclient.getEmail());
        }
        if(newclient.getAddress() != null &&
                !newclient.getAddress().isEmpty() &&
                !Objects.equals(client.getAddress(), newclient.getAddress())){
            client.setAddress(newclient.getAddress());
        }
        if(newclient.getPassword() != null &&
                !newclient.getPassword().isEmpty() &&
                !Objects.equals(client.getPassword(), newclient.getPassword())){
            client.setPassword(newclient.getPassword());
        }
        clientRepository.save(client);
    }


    public Client retrieveClientByUsername(String username){
        Optional<Client> clientOptional =
                clientRepository.findClientByUsername(username);
        if(clientOptional.isEmpty()){
            throw new IllegalStateException("username not found");
        }
        Client ret = null;
        List<Client> c = clientRepository.findAll();
        for (Client temp : c) {
            if (temp.getUsername().equals(username)) {
                ret = temp;
            }
        }
        return ret;
    }
}
