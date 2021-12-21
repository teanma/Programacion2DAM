package org.iesfm.examen1accesodatos;

import java.util.Date;
import java.util.Objects;

public class Movement {
    private int id;
    private String iban;
    private String movement_date;
    private double amount;
    private String description;

    public Movement(int id, String iban, String movement_date, double amount, String description) {
        this.id = id;
        this.iban = iban;
        this.movement_date = movement_date;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getMovement_date() {
        return movement_date;
    }

    public void setMovement_date(String movement_date) {
        this.movement_date = movement_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return id == movement.id && Double.compare(movement.amount, amount) == 0 && Objects.equals(iban, movement.iban) && Objects.equals(movement_date, movement.movement_date) && Objects.equals(description, movement.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban, movement_date, amount, description);
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", movement_date='" + movement_date + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
