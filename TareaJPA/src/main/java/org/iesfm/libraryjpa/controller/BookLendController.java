package org.iesfm.libraryjpa.controller;

import org.iesfm.libraryjpa.BookLend;
import org.iesfm.libraryjpa.repository.BookLendRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookLendController {

    private BookLendRepository bookLendRepository;

    public BookLendController(BookLendRepository bookLendRepository) {
        this.bookLendRepository = bookLendRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/members/{nif}/booklends")
    public List<BookLend> listByNif(@PathVariable("nif") String nif) {
        return bookLendRepository.findMemberBookLendByNif(nif);
    }
}
