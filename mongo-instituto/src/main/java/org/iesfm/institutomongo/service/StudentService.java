package org.iesfm.institutomongo.service;

import org.iesfm.institutomongo.Absence;
import org.iesfm.institutomongo.Group;
import org.iesfm.institutomongo.Student;
import org.iesfm.institutomongo.exceptions.GroupNotFoundException;
import org.iesfm.institutomongo.exceptions.StudentNotFoundException;
import org.iesfm.institutomongo.repository.GroupRepository;
import org.iesfm.institutomongo.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private GroupRepository groupRepository;

    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public boolean insertStudentToGroup(Student student, Group group) throws GroupNotFoundException {
        if(!groupRepository.existsById(group.getId())) {
            return false;
        }
        studentRepository.insertToGroup(student);
        return true;
    }

    public boolean delete(String nif) throws StudentNotFoundException {
        if(!studentRepository.existsById(nif)) {
            throw new StudentNotFoundException(nif);
        }
        studentRepository.delete(nif);
        return true;
    }

    public boolean update(Student student) throws StudentNotFoundException {
        if(!studentRepository.existsById(student.getNif())) {
            throw new StudentNotFoundException(student.getNif());
        }
        return studentRepository.update(student);
    }
}
