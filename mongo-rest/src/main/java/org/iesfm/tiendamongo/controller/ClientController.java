package org.iesfm.tiendamongo.controller;

import org.iesfm.tiendamongo.Article;
import org.iesfm.tiendamongo.Client;
import org.iesfm.tiendamongo.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/clients")
    public void insert(@RequestBody Client client) {
        if (client.getNif() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client already exists");
        } else {
            clientRepository.insertClient(client);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/clients")
    public List<Client> list() {
        return clientRepository.listClients();
    }
}
