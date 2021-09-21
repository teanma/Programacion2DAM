package org.iesfm.supermarket;

import java.util.Objects;

public class Cashier extends Employee {

    private String cashierStore;
    private int tellerNumber;

    public Cashier(String nif, String name, String surname, int workedHours, String cashierStore, int tellerNumber) {
        super(nif, name, surname, workedHours);
        this.cashierStore = cashierStore;
        this.tellerNumber = tellerNumber;
    }

    @Override
    protected void showSpecificInfo() {
        System.out.println("Soy el cajero");
        System.out.println("Tienda en la que trabajo: " + cashierStore);
        System.out.println("Número de cajero: " + tellerNumber);
    }

    public String getCashierStore() {
        return cashierStore;
    }

    public void setCashierStore(String cashierStore) {
        this.cashierStore = cashierStore;
    }

    public int getTellerNumber() {
        return tellerNumber;
    }

    public void setTellerNumber(int tellerNumber) {
        this.tellerNumber = tellerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cashier cashier = (Cashier) o;
        return tellerNumber == cashier.tellerNumber && Objects.equals(cashierStore, cashier.cashierStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cashierStore, tellerNumber);
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "cashierStore='" + cashierStore + '\'' +
                ", tellerNumber=" + tellerNumber +
                '}';
    }
}
