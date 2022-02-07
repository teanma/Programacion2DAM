package org.iesfm.library.api.controllers;

import org.iesfm.library.pojos.Book;
import org.iesfm.library.pojos.BookLend;
import org.iesfm.library.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/books")
    public void insert(@RequestBody Book book) {
        if(!bookService.insert(book)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book already exists");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/books")
    public List<Book> list() {
        return bookService.list();
    }

    public List<Book> listMemberBookLends(String nif) {
        return null;
    }
}
