package org.iesfm.restexample;

import java.util.Objects;

public class Employee {

    private String nif;
    private String name;
    private String surname;
    private String role;
    private String department_name;

    public Employee(String nif, String name, String surname, String role, String department_name) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.department_name = department_name;
    }

    public Employee() {

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(nif, employee.nif) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(role, employee.role) && Objects.equals(department_name, employee.department_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, role, department_name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
