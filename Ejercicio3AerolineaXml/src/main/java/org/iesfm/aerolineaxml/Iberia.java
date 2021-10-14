package org.iesfm.aerolineaxml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;
import java.util.Objects;

@XStreamAlias("iberia")
public class Iberia {

    private String name;
    private List<Flight> flights;

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
