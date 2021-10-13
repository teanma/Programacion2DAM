package org.iesfm.aerolineaxml;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Flight {

    private int number;
    private String origin;
    private String destination;
    private Date date;
    private List<Passenger> passengers;


    public Flight(int number, String origin, String destination, Date date, List<Passenger> passengers) {
        this.number = number;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.passengers = passengers;
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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return number == flight.number && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(date, flight.date) && Objects.equals(passengers, flight.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, origin, destination, date, passengers);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "number=" + number +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", passengers=" + passengers +
                '}';
    }
}
