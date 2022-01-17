package org.iesfm.libraryjpa.controller;

import org.iesfm.libraryjpa.Book;
import org.iesfm.libraryjpa.repository.BookRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/books/{author}")
    public List<Book> listByAuthor(@PathVariable("author") String author) {
        return bookRepository.findBookByAuthor(author);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/booklends/{isbn}/books")
    public List<Book> listLendedBooks(@PathVariable("isbn") String booklendIsbn) {
        return bookRepository.findLendedBooks(booklendIsbn);
    }

}
