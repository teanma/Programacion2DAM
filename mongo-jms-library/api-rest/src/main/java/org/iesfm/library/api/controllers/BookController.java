package org.iesfm.library.api.controllers;

import org.iesfm.library.Book;
import org.iesfm.library.BookLend;
import org.iesfm.library.Member;
import org.iesfm.library.api.pojos.MemberApi;
import org.iesfm.library.servicies.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /*@RequestMapping(method = RequestMethod.POST, path = "/books")
    public void insert(@RequestBody Book book) {
        if(!bookService.insert(book)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book already exists");
        }
    }

    private Member convert(MemberApi member) {
        return new Member(
                member.getNif(),
                member.getName(),
                member.getSurname(),
                member.getEmail(),
                member.getPhone(),
                new LinkedList<>()
        );
    }

    @RequestMapping(method = RequestMethod.GET, path = "/books")
    public List<Book> list() {
        return bookService.list();
    }

    public List<Book> listMemberBookLends(String isbn, String nif) {
        try {
            return bookService.findMemberBookLends(isbn, nif);
        } catch (MemberNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member " + e.getNif() + " not found");
        }
    }*/
}
