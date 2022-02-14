package org.iesfm.airline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PassengerId implements Serializable {

    private String nif;
    private int number;

    @JsonCreator
    public PassengerId(
            @JsonProperty(value = "nif", required = true) String nif,
            @JsonProperty(value = "number", required = true) int number) {
        this.nif = nif;
        this.number = number;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
