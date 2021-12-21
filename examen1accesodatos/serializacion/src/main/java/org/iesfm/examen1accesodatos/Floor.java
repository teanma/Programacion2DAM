package org.iesfm.examen1accesodatos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class Floor {
    private static final Logger log = LoggerFactory.getLogger(Floor.class);
    private int number;
    private List<Apartment> apartments;

    @JsonCreator
    public Floor(
            @JsonProperty("number") int number,
            @JsonProperty("apartments") List<Apartment> apartments) {
        this.number = number;
        this.apartments = apartments;
    }

    public void showinfo() {
        log.info("Numero: " + number);
        log.info("Apartamentos: ");
        for (Apartment apparment : apartments) {
            apparment.showInfo();
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return number == floor.number && Objects.equals(apartments, floor.apartments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, apartments);
    }

    @Override
    public String toString() {
        return "Floor{" +
                "number=" + number +
                ", appartments=" + apartments +
                '}';
    }
}

