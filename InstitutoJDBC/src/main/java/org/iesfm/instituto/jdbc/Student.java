package org.iesfm.instituto.jdbc;

import java.util.Objects;

public class Student {

    private String nif;
    private String student_name;
    private String student_surname;
    private int zipcode;
    private String address;
    private String email;

    public Student(String nif, String student_name, String student_surname, int zipcode, String address, String email) {
        this.nif = nif;
        this.student_name = student_name;
        this.student_surname = student_surname;
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

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_surname() {
        return student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
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
        return zipcode == student.zipcode && Objects.equals(nif, student.nif) && Objects.equals(student_name, student.student_name) && Objects.equals(student_surname, student.student_surname) && Objects.equals(address, student.address) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, student_name, student_surname, zipcode, address, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "nif='" + nif + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_surname='" + student_surname + '\'' +
                ", zipcode=" + zipcode +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
