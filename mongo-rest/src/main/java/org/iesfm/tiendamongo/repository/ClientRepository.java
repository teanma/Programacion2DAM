package org.iesfm.tiendamongo.repository;

import org.iesfm.tiendamongo.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    //void insertClient(Client client);
    //List<Client> listClients();
}
