package org.iesfm.library.api.controllers;

import org.iesfm.library.BookLend;
import org.iesfm.library.Member;
import org.iesfm.library.servicies.BookService;
import org.iesfm.library.servicies.MemberService;
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
    private BookService bookService;

    public MemberController(MemberService memberService, BookService bookService) {
        this.memberService = memberService;
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/members")
    public void insert(@RequestBody Member member) {
        if(!memberService.insert(member)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Member already exists");
        }
    }

    /*@RequestMapping(method = RequestMethod.GET, path = "/members")
    public List<Member> list() {
        return memberService.list();
    }*/

    /*@RequestMapping(method = RequestMethod.GET, path = "/members/{nif}/booklends")
    public List<BookLend> listMemberLends(String nif) {
        try {
            return memberService.memberLends(nif);
        } catch (MemberNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member " + e.getNif() + " not found");
        }
    }*/
}
