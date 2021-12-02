package org.iesfm.institutoorm;

import java.util.Objects;

public class Student {

    private String nif;
    private String name;
    private String surname;
    private int zipcode;
    private String address;
    private String email;

    public Student(String nif, String name, String surname, int zipcode, String address, String email) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.zipcode = zipcode;
        this.address = address;
        this.email = email;
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return zipcode == student.zipcode && Objects.equals(nif, student.nif) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(address, student.address) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, zipcode, address, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", zipcode=" + zipcode +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
