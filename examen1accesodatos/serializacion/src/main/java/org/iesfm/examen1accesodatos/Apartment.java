package org.iesfm.examen1accesodatos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class Apartment {
    private static final Logger log = LoggerFactory.getLogger(Apartment.class);
    @JsonProperty("class")
    private String type;
    private String door;
    private List<String> owners;

    @JsonCreator
    public Apartment(
           @JsonProperty("class") String type,
           @JsonProperty("door") String door,
           @JsonProperty("owners") List<String> owners) {
        this.type = type;
        this.door = door;
        this.owners = owners;
    }

    public void showInfo() {
        log.info("Clase: " + type);
        log.info("Puerta: " + door);
        log.info("Dueños: ");
        for(String owner : owners){
            log.info(owner);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public List<String> getOwners() {
        return owners;
    }

    public void setOwners(List<String> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment that = (Apartment) o;
        return Objects.equals(type, that.type) && Objects.equals(door, that.door) && Objects.equals(owners, that.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, door, owners);
    }

    @Override
    public String toString() {
        return "Appartment{" +
                "type='" + type + '\'' +
                ", door='" + door + '\'' +
                ", owners=" + owners +
                '}';
    }
}
