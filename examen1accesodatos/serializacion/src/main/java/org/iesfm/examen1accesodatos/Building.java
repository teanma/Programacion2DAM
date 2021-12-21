package org.iesfm.examen1accesodatos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Building {

    private static final Logger log = LoggerFactory.getLogger(Building.class);
    private String address;
    private int cp;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private List<Floor> floors;

    @JsonCreator
    public Building(
            @JsonProperty("address") String address,
            @JsonProperty("cp") int cp,
            @JsonProperty("date") Date date,
            @JsonProperty("floors") List<Floor> floors) {
        this.address = address;
        this.cp = cp;
        this.date = date;
        this.floors = floors;
    }

    public void showInfo() {
        log.info("Direccion: " + address);
        log.info("Codigo postal: " + cp);
        log.info("Fecha: " + date);
        log.info("Piso: ");
        for(Floor floor: floors){
            floor.showinfo();
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return cp == building.cp && Objects.equals(address, building.address) && Objects.equals(date, building.date) && Objects.equals(floors, building.floors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, cp, date, floors);
    }

    @Override
    public String toString() {
        return "Bulding{" +
                "address='" + address + '\'' +
                ", cp=" + cp +
                ", date=" + date +
                ", floors=" + floors +
                '}';
    }
}
