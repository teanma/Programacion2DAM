package org.iesfm.library.services;

import org.iesfm.library.exceptions.MemberNotFoundException;
import org.iesfm.library.pojos.Book;
import org.iesfm.library.pojos.BookLend;
import org.iesfm.library.pojos.Member;
import org.iesfm.library.repository.BookRepository;
import org.iesfm.library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    public BookService(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public boolean insert(Book book) {
        if(bookRepository.existsById(book.getIsbn())) {
            return false;
        }
        bookRepository.insert(book);
        return true;
    }

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public List<BookLend> findMemberBookLends(String isbn, String nif) throws MemberNotFoundException {
        if(!memberRepository.existsById(nif)) {
            throw new MemberNotFoundException(nif);
        }
        return bookRepository.findLendedBooksByNif(nif);
    }
}
