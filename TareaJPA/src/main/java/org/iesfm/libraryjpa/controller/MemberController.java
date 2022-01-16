package org.iesfm.libraryjpa.controller;

import org.iesfm.libraryjpa.Member;
import org.iesfm.libraryjpa.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class MemberController {

    private MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/members")
    public List<Member> listByName(@PathVariable("name") String name) {
        return memberRepository.findMembersByName(name);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, path = "/members/{name, surname}")
    public void deleteByNameAndSurname(@PathVariable("name") String name, @PathVariable("surname") String surname) {
        int deletedRows = memberRepository.deleteByNameAndSurname(name, surname);
        if (deletedRows == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "");
        }
    }
}
