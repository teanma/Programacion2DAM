package org.iesfm.restexample.dao.inmemory;

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
    public boolean insert(Employee employee) {
        if (!employees.containsKey(employee.getNif())) {
            employees.put(employee.getNif(), employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String nif) {
        if(employees.containsKey(nif)) {
            employees.remove(nif);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> list(String departmentName) {
        return list();
    }
}
