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

    public List<Student> listStudentsByGroup(int groupId) throws GroupNotFoundException {
        if (!groupRepository.existsById(groupId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found");
        }
        return studentRepository.listStudentsByGroup(groupId);
    }

    /*public boolean insertStudentToGroup(Student student, Group group) throws GroupNotFoundException {
        if(!groupRepository.existsById(group.getId())) {
            return false;
        }
        studentRepository.insertToGroup(student);
        return true;
    }*/

    public boolean delete(String nif) throws StudentNotFoundException {
        if(!studentRepository.existsById(nif)) {
            throw new StudentNotFoundException(nif);
        }
        studentRepository.deleteById(nif);
        return true;
    }

    public boolean update(Student student) throws StudentNotFoundException {
        if(!studentRepository.existsById(student.getNif())) {
            throw new StudentNotFoundException(student.getNif());
        }
        studentRepository.updateByNif(student);
        return true;
    }
}
