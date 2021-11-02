package org.iesfm.restexample.controller;

import org.iesfm.restexample.Department;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class DepartmentController {

    private List<Department> departments = Arrays.asList(
            new Department("Informática", "Cosas de ordenadores"),
            new Department("Marketing", "Cosas de ventas")
    );

    @RequestMapping(method = RequestMethod.GET, path = "/department")
    public List<Department> list() {
        return departments;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/department")
    public void createDepartment(@RequestBody Department department) {
        departments.add(department);
    }
}
