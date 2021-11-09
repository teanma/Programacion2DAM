package org.iesfm.restexample.dao.inmemory;

import org.iesfm.restexample.Department;
import org.iesfm.restexample.Employee;
import org.iesfm.restexample.dao.EmployeeDAO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InMemoryEmployeeDAO implements EmployeeDAO {

    private Map<String, Employee> employees = new HashMap<>();

    @Override
    public List<Employee> list() {
        return new LinkedList<>(employees.values());
    }

    @Override
    public Employee get(String nif) {
        return employees.get(nif);
    }

    @Override
    public void insert(Employee employee) {
        employees.put(employee.getNif(), employee);
    }

    @Override
    public void delete(String nif) {
        employees.remove(nif);
    }
}
