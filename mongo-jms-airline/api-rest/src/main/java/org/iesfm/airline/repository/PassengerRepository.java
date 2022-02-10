package org.iesfm.airline.repository;

import org.iesfm.airline.Passenger;
import org.iesfm.airline.PassengerId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PassengerRepository extends MongoRepository<Passenger, PassengerId> {

    void insertToFlight(int number, int passengerId);

    @Query("{'passengerId.nif': ?0}")
    List<Passenger> listPassengersFlight(int number);

    Passenger findByPassengerId(PassengerId passengerId);
}
