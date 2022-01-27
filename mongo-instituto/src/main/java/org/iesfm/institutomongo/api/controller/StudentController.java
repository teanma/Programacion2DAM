package org.iesfm.institutomongo.api.controller;

import org.iesfm.institutomongo.Group;
import org.iesfm.institutomongo.Student;
import org.iesfm.institutomongo.exceptions.StudentNotFoundException;
import org.iesfm.institutomongo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/students")
    public void update(@RequestBody Student student) throws StudentNotFoundException {
        if(!studentService.update(student)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe el grupo");
        }
    }
}
