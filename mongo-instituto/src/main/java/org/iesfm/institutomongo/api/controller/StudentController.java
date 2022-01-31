package org.iesfm.institutomongo.api.controller;

import org.iesfm.institutomongo.Group;
import org.iesfm.institutomongo.Student;
import org.iesfm.institutomongo.exceptions.GroupNotFoundException;
import org.iesfm.institutomongo.exceptions.StudentNotFoundException;
import org.iesfm.institutomongo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "groups/{groupId}/students")
    public List<Student> listStudentsByGroup(@PathVariable ("groupId") int groupId) {
        try {
            return studentService.listStudentsByGroup(groupId);
        } catch (GroupNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el grupo " + e.getId());
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/students")
    public void update(@RequestBody Student student) throws StudentNotFoundException {
        if(!studentService.update(student)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/students")
    public void delete(@PathVariable String nif) throws StudentNotFoundException {
        if(!studentService.delete(nif)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
    }
}
