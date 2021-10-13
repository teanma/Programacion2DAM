package org.iesfm.aerolinea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Passenger {

    private String nif;
    @JsonProperty("class")
    private String ticketClass;
    private int seat;

    @JsonCreator
    public Passenger(
            @JsonProperty("nif") String nif,
            @JsonProperty("class") String ticketClass,
            @JsonProperty("seat") int seat) {
        this.nif = nif;
        this.ticketClass = ticketClass;
        this.seat = seat;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return seat == passenger.seat && Objects.equals(nif, passenger.nif) && Objects.equals(ticketClass, passenger.ticketClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, ticketClass, seat);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "nif='" + nif + '\'' +
                ", ticketClass='" + ticketClass + '\'' +
                ", seat=" + seat +
                '}';
    }
}
