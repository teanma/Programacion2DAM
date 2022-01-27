package org.iesfm.institutomongo.api.controller;

import org.iesfm.institutomongo.Group;
import org.iesfm.institutomongo.exceptions.GroupNotFoundException;
import org.iesfm.institutomongo.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/groups")
    public List<Group> list() {
        return groupService.list();
    }

    @RequestMapping(method = RequestMethod.GET, path = "students/{nif}/groups")
    public List<Group> listStudentsByGroup(@PathVariable ("nif") String nif) {
        try {
            return groupService.listStudentsByGroup(nif);
        } catch (GroupNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el grupo " + e.getId());
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/groups")
    public void insert(@RequestBody Group group) {
        if(!groupService.insert(group)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe el grupo");
        }
    }
}
