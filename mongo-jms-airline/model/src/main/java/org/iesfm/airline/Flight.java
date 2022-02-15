package org.iesfm.airline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "flights")
public class Flight {

    @Id
    private int flightNumber;
    private String origin;
    private String destination;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;

    @JsonCreator
    public Flight(
            @JsonProperty(value = "flightNumber", required = true) int flightNumber,
            @JsonProperty(value = "origin", required = true) String origin,
            @JsonProperty(value = "destination", required = true) String destination,
            @JsonProperty(value = "date", required = true) Date date) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightNumber == flight.flightNumber && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(date, flight.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, origin, destination, date);
    }


}
