package org.iesfm.airline.repository;

import org.iesfm.airline.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface FlightRepository extends MongoRepository<Flight, Integer> {

    Flight findByFlightNumber(int number);
}
