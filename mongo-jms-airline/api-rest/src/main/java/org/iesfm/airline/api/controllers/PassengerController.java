package org.iesfm.airline.api.controllers;

import org.iesfm.airline.pojos.Flight;
import org.iesfm.airline.pojos.Passenger;
import org.iesfm.airline.repository.FlightRepository;
import org.iesfm.airline.repository.PassengerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PassengerController {

    private PassengerRepository passengerRepository;
    private FlightRepository flightRepository;

    public PassengerController(PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/flights/{number}/passengers/{passengerId}")
    public void insertPassengerToFlight(int number, int passengerId) {
        if(flightRepository.existsById(number)) {
            if (!passengerRepository.existsById(passengerId)) {
                passengerRepository.insertToFlight(number, passengerId);
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Passenger already exists");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");

        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/flights/{number}/passengers")
    public List<Passenger> listPassengersFlight(int number) {
        if(!flightRepository.existsById(number)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");
        }
        return passengerRepository.listPassengersFlight(number);
    }
}
