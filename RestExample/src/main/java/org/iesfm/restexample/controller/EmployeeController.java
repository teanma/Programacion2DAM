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

    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/employee")
    public List<Employee> listEmployee() {
        return employeeDAO.list();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/employees")
    public void createEmployee(@RequestBody Employee employee) {
        boolean inserted = employeeDAO.insert(employee);
        if (!inserted) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "employee already exists"
            );
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "employees/{employeeNif}")
    public Employee getEmployee(@PathVariable ("employeeNif") String employeeNif) {
        Employee employee = employeeDAO.get(employeeNif);
        if (employee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "employee not found"
            );
        } else {
            return employee;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/employees/{employeeNif}")
    public void deleteEmployee(@PathVariable ("employeeNif") String employeeNif) {
        Employee employee = employeeDAO.delete(employeeNif);
        if (employee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "employee not found"
            );
        } else {
            return employee;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/departments/{departmentName}/employees")
    public List<Employee> getEmployeeFromDepartment(@PathVariable ("departmentName") String departmentName) {
        List<Employee>  employees = employeeDAO.list(departmentName);
        if (employees == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "department not found"
            );
        } else {
            return employees;
        }
    }
}
