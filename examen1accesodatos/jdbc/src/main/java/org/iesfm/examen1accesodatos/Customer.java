package org.iesfm.examen1accesodatos;

import javax.annotation.processing.Generated;
import java.util.Objects;

public class Customer {

    private int id;
    private String nif;
    private String name;
    private String surname;
    private int cp;

    public Customer(int id, String nif, String name, String surname, int cp) {
        this.id = id;
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.cp = cp;
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && cp == customer.cp && Objects.equals(nif, customer.nif) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nif, name, surname, cp);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cp=" + cp +
                '}';
    }
}
