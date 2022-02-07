package org.iesfm.library.api.controllers;

import org.iesfm.library.pojos.BookLend;
import org.iesfm.library.pojos.Member;
import org.iesfm.library.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/members")
    public void insert(@RequestBody Member member) {
        if(!memberService.insert(member)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Member already exists");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/members")
    public List<Member> list() {
        return memberService.list();
    }

    public List<BookLend> listMemberLends(String nif) {
        return null;
    }
}
