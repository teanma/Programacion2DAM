package org.iesfm.institutomongo.service;

import org.iesfm.institutomongo.Group;
import org.iesfm.institutomongo.exceptions.GroupNotFoundException;
import org.iesfm.institutomongo.repository.GroupRepository;
import org.iesfm.institutomongo.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GroupService {

    private GroupRepository groupRepository;
    private StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public List<Group> list() {
        return groupRepository.findAll();
    }

    public List<Group> listStudentsByGroup(String nif) throws GroupNotFoundException {
        if (!studentRepository.existsById(nif)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found");
        }
        return groupRepository.findStudentsByGroup(nif);
    }

    public boolean insert(Group group) {
        if(groupRepository.existsById(group.getId())) {
            return false;
        }
        groupRepository.insert(group);
        return true;
    }
}
