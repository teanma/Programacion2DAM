package org.iesfm.airline.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "passengers")
public class Passenger {

    @Id
    private PassengerId passengerId;
    private String email;
    private String name;
    private String surname;
    private String seat;
    private List<Baggage> baggages;

    @JsonCreator
    public Passenger(
            @JsonProperty("passengerId") PassengerId passengerId,
            @JsonProperty("email") String email,
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("seat") String seat,
            @JsonProperty("baggages") List<Baggage> baggages) {
        this.passengerId = passengerId;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.seat = seat;
        this.baggages = baggages;
    }

    public PassengerId getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(PassengerId passengerId) {
        this.passengerId = passengerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public List<Baggage> getBaggages() {
        return baggages;
    }

    public void setBaggages(List<Baggage> baggages) {
        this.baggages = baggages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(passengerId, passenger.passengerId) && Objects.equals(email, passenger.email) && Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname) && Objects.equals(seat, passenger.seat) && Objects.equals(baggages, passenger.baggages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, email, name, surname, seat, baggages);
    }
}
