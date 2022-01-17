package org.iesfm.libraryjpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BookLendId implements Serializable {

    @Column(name = "member_id", nullable = false)
    private int memberId;
    @Column(nullable = false)
    private String isbn;
    @Column(name = "lend_date", nullable = false)
    private Date lendDate;

    public BookLendId(int memberId, String isbn, Date lendDate) {
        this.memberId = memberId;
        this.isbn = isbn;
        this.lendDate = lendDate;
    }

    public BookLendId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLendId that = (BookLendId) o;
        return memberId == that.memberId && Objects.equals(isbn, that.isbn) && Objects.equals(lendDate, that.lendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, isbn, lendDate);
    }
}
