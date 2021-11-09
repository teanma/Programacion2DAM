package org.iesfm.restexample.dao;

import org.iesfm.restexample.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> list();

    Employee get(String nif);

    void insert(Employee employee);

    void delete(String nif);
}
