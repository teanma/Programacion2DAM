package org.iesfm.airline.pojos;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class PassengerId implements Serializable {

    private String nif;
    private int number;

    public PassengerId(String nif, int number) {
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
