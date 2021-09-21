package org.iesfm.supermarket;

import java.util.Objects;

public class President extends Employee {

    private String supermarketName;

    public President(String nif, String name, String surname, int workedHours, String supermarketName) {
        super(nif, name, surname, workedHours);
        this.supermarketName = supermarketName;
    }

    @Override
    protected void showSpecificInfo() {
        System.out.println("Soy el presidente");
        System.out.println("Nombre de mi cadena de supermercados: " + supermarketName);
    }

    public String getSupermarketName() {
        return supermarketName;
    }

    public void setSupermarketName(String supermarketName) {
        this.supermarketName = supermarketName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        President president = (President) o;
        return Objects.equals(supermarketName, president.supermarketName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), supermarketName);
    }

    @Override
    public String toString() {
        return "President{" +
                "supermarketName='" + supermarketName + '\'' +
                '}';
    }
}
