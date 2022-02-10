package org.iesfm.airline.api.controllers;

import org.iesfm.airline.Flight;
import org.iesfm.airline.repository.FlightRepository;
import org.iesfm.airline.repository.PassengerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class FlightController {

    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/flights")
    public void insert(@RequestBody Flight flight) {
        if(flightRepository.existsById(flight.getNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Flight already exists");
        } else {
            flightRepository.save(flight);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/flights")
    public List<Flight> list() {
        return flightRepository.findAll();
    }


}
