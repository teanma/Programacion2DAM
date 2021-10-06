package org.iesfm.companyjson;

import java.util.Objects;

public class Employee {

    private String nif;
    private String name;
    private String surname;
    private String employeeJob;

    public Employee() {

    }

    public Employee(String nif, String name, String surname, String employeeJob) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.employeeJob = employeeJob;
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

    public String getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(nif, employee.nif) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(employeeJob, employee.employeeJob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, employeeJob);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", employeeJob='" + employeeJob + '\'' +
                '}';
    }
}
