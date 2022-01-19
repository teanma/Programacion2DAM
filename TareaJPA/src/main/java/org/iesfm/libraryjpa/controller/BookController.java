package org.iesfm.libraryjpa.controller;

import org.iesfm.libraryjpa.Book;
import org.iesfm.libraryjpa.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/books")
    public List<Book> listByAuthor(@RequestParam(value = "author", required = false) String author) {
        if (author == null) {
            return bookRepository.findAllLendedBooks();
        } else {
            return bookRepository.findBookByAuthor(author);
        }
    }
}
