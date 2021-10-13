package org.iesfm.aerolineaxml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Iberia {

    private String name;
    private List<Flight> flights;


    public Iberia(String name, List<Flight> flights) {
        this.name = name;
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Iberia iberia = (Iberia) o;
        return Objects.equals(name, iberia.name) && Objects.equals(flights, iberia.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, flights);
    }

    @Override
    public String toString() {
        return "Iberia{" +
                "name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }
}
