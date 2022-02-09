package org.iesfm.airline.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "flights")
public class Flight {

    @Id
    private int number;
    private String origin;
    private String destination;
    private Date date;

    @JsonCreator
    public Flight(
            @JsonProperty("number") int number,
            @JsonProperty("origin") String origin,
            @JsonProperty("destination") String destination,
            @JsonProperty("date") Date date) {
        this.number = number;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
        return number == flight.number && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(date, flight.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, origin, destination, date);
    }
}
