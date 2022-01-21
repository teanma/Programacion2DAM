package org.iesfm.libraryjpa.controller;

import org.iesfm.libraryjpa.Member;
import org.iesfm.libraryjpa.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class MemberController {

    private MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/members")
    public List<Member> listByName(@RequestParam(value = "name", required = false) String name) {
        return memberRepository.findMemberByName(name);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, path = "/members")
    public void deleteByNameAndSurname(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname) {
        int deletedRows = memberRepository.deleteByNameAndSurname(name, surname);
        if (deletedRows == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "");
        }
    }
}
