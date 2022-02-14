package org.iesfm.airline.api.controllers;

import org.iesfm.airline.*;
import org.iesfm.airline.repository.FlightRepository;
import org.iesfm.airline.repository.PassengerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;

@RestController
public class PassengerController {

    private PassengerRepository passengerRepository;
    private FlightRepository flightRepository;
    private JmsTemplate jmsTemplate;

    public PassengerController(PassengerRepository passengerRepository, FlightRepository flightRepository, JmsTemplate jmsTemplate) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
        this.jmsTemplate = jmsTemplate;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/flights/{number}/passengers")
    public void insertPassengerToFlight(@PathVariable("number") int number, @RequestBody Passenger passenger) {
        if (flightRepository.existsById(number)) {
            if (!passengerRepository.existsById(passenger.getPassengerId())) {
                Flight flight = flightRepository.findByFlightNumber(number);
                passengerRepository.insert(passenger);
                jmsTemplate.convertAndSend("airline_emails", new Email("emailpruebas@gmail.com" +
                        passenger.getEmail() +
                        "Bienvenido a bordo del vuelo " + flight.getNumber(),
                        ".\nBienvenido: " + passenger.getName() + " " + passenger.getSurname() +
                                ".\n Tu vuelo saldrá el día " + flight.getDate() + " desde " + flight.getOrigin() + " a " +
                                flight.getDestination() + "." +
                                " Tu asiento es: " + passenger.getSeat() + "." +
                                "\n No lo pierdas! \n Hasta pronto"
                ));
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Passenger already exists");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");

        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/flights/{number}/passengers")
    public List<Passenger> listPassengersFlight(@PathVariable("number") int number) {
        if (!flightRepository.existsById(number)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");
        }
        return passengerRepository.listPassengersFlight(number);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/flights/{number}/passengers/{nif}/baggages")
    public void insertBaggageToPassenger(@PathVariable("nif") String nif, @PathVariable("number") int number, @RequestBody Baggage baggage) {
        if(flightRepository.existsById(number)) {
            if (passengerRepository.existsById(new PassengerId(nif, number))) {
                Passenger passenger = passengerRepository.findByPassengerId(new PassengerId(nif, number));
                List<Baggage> baggages = new LinkedList<>();
                baggages.add(baggage);
                passenger.setBaggages(baggages);
                passengerRepository.save(passenger);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "passengers/{nif}/baggages")
    public List<Baggage> listPassengerBaggages(String nif, int number) {
        if(!passengerRepository.existsById(new PassengerId(nif, number))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found");
        }
        Passenger passenger = passengerRepository.findByPassengerId(new PassengerId(nif, number));
        return passenger.getBaggages();
    }
}
