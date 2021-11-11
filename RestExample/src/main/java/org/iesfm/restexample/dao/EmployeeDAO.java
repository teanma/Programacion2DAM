package org.iesfm.restexample.dao;

import org.iesfm.restexample.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> list();

    Employee get(String nif);

    boolean insert(Employee employee);

    boolean delete(String nif);

    List<Employee> list(String departmentName);
}
