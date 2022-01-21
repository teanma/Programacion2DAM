package org.iefm.mongo.repository;

import org.iefm.mongo.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmailRepository extends MongoRepository<Email, Integer> {

    List<Email> findByTo(String to);
    List<Email> findByTo(List<String> to);
}
