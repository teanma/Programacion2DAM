package org.iesfm.restexample.controller;

import org.iesfm.restexample.Employee;
import org.iesfm.restexample.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/employee")
    public List<Employee> listEmployee() {
        return employeeDAO.list();
    }

    @RequestMapping(method = RequestMethod.GET, path = "employee/{employeeNif}")
    public Employee getEmployee(@PathVariable ("employeeNif") String nif) {
        return employeeDAO.get(nif);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/employee")
    public void createEmployee(@RequestBody Employee employee) {
        employeeDAO.insert(employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/employee/{employeeNif}")
    public void deleteEmployee(@PathVariable ("employeeNif") String nif) {
        employeeDAO.delete(nif);
    }
}
