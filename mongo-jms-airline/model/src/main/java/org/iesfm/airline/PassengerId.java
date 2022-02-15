package org.iesfm.airline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PassengerId implements Serializable {

    private String nif;
    private int flightNumber;

    @JsonCreator
    public PassengerId(
            @JsonProperty(value = "nif", required = true) String nif,
            @JsonProperty(value = "flightNumber", required = true) int flightNumber) {
        this.nif = nif;
        this.flightNumber = flightNumber;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
}
