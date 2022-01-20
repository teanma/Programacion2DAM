package org.iesfm.tiendamongo.repository;

import org.iesfm.tiendamongo.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientRepository extends MongoRepository<Client, String> {

    void insertClient(Client client);
    List<Client> listClients();
}
