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

    @RequestMapping(method = RequestMethod.POST, path = "/flights/{flightNumber}/passengers")
    public void insertPassengerToFlight(@PathVariable("flightNumber") int flightNumber, @RequestBody Passenger passenger) {
        if (flightRepository.existsById(flightNumber)) {
            if (!passengerRepository.existsById(passenger.getPassengerId())) {
                Flight flight = flightRepository.findByFlightNumber(flightNumber);
                passengerRepository.insert(passenger);
                jmsTemplate.convertAndSend("airline_emails", new Email(passenger.getEmail(),
                        "iesfmpruebas@gmail.com",
                        "Bienvenido a bordo del vuelo " + flight.getFlightNumber() + "\n",
                        "Bienvenido: " + passenger.getName() + " " + passenger.getSurname() + "," + "\n"
                                + "Tu vuelo saldra el dia " + flight.getDate() + " "
                                + "desde " + flight.getOrigin() + " a " + flight.getDestination() + "." + "\n"
                                + "Tu asiento es: " + passenger.getSeat() + "." + "\n"
                                + "No lo pierdas!" + "\n"
                                + "Hasta pronto"
                ));
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Passenger already exists");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");

        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/flights/{flightNumber}/passengers")
    public List<Passenger> listPassengersFlight(@PathVariable("flightNumber") int flightNumber) {
        if (!flightRepository.existsById(flightNumber)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");
        }
        return passengerRepository.listPassengersFlight(flightNumber);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/flights/{flightNumber}/passengers/{nif}/baggages")
    public void insertBaggageToPassenger(@PathVariable("nif") String nif, @PathVariable("flightNumber") int flightNumber, @RequestBody Baggage baggage) {
        if(flightRepository.existsById(flightNumber)) {
            if (passengerRepository.existsById(new PassengerId(nif, flightNumber))) {
                Passenger passenger = passengerRepository.findByPassengerId(new PassengerId(nif, flightNumber));
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

    @RequestMapping(method = RequestMethod.GET, path = "flights/{flightNumber}/passengers/{nif}/baggages")
    public List<Baggage> listPassengerBaggages(@PathVariable("nif") String nif, @PathVariable("flightNumber") int flightNumber) {
        if(!passengerRepository.existsById(new PassengerId(nif, flightNumber))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found");
        }
        Passenger passenger = passengerRepository.findByPassengerId(new PassengerId(nif, flightNumber));
        return passenger.getBaggages();
    }
}
