package org.iesfm.libraryjpa;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "book_lend")
public class BookLend {

    @Id
    @Column(name = "member_id", nullable = false)
    private int memberId;
    @Id
    @Column(nullable = false)
    private String isbn;
    @Id
    @Column(name = "lend_date", nullable = false)
    private Date lendDate;
    @Id
    @OneToOne
    private Book book;

    public BookLend(int memberId, String isbn, Date lendDate, Book book) {
        this.memberId = memberId;
        this.isbn = isbn;
        this.lendDate = lendDate;
        this.book = book;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLend bookLend = (BookLend) o;
        return memberId == bookLend.memberId &&
                Objects.equals(isbn, bookLend.isbn) &&
                Objects.equals(lendDate, bookLend.lendDate) &&
                Objects.equals(book, bookLend.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, isbn, lendDate, book);
    }
}
