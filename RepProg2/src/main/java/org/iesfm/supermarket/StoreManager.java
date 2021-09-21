package org.iesfm.supermarket;

import java.util.Objects;

public class StoreManager extends Employee {

    private String managerStore;

    public StoreManager(String nif, String name, String surname, int workedHours, String managerStore) {
        super(nif, name, surname, workedHours);
        this.managerStore = managerStore;
    }

    @Override
    protected void showSpecificInfo() {
        System.out.println("Soy el jefe de tienda");
        System.out.println("Tienda que dirijo: " + managerStore);
    }

    public String getManagerStore() {
        return managerStore;
    }

    public void setManagerStore(String managerStore) {
        this.managerStore = managerStore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StoreManager that = (StoreManager) o;
        return Objects.equals(managerStore, that.managerStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), managerStore);
    }

    @Override
    public String toString() {
        return "StoreManager{" +
                "managerStore='" + managerStore + '\'' +
                '}';
    }
}
