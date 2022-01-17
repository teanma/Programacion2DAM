package org.iefm.mongo.repository;

import org.iefm.mongo.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmailRepository extends MongoRepository<Email, Integer> {
}
