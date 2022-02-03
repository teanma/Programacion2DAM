package org.iesfm.library.pojos;

import java.util.Objects;

public class BookLend {

    private String isbn;
    private String status;
    private String lendDate;
    private String returnDate;

    public BookLend(String isbn, String status, String lendDate, String returnDate) {
        this.isbn = isbn;
        this.status = status;
        this.lendDate = lendDate;
        this.returnDate = returnDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLend bookLend = (BookLend) o;
        return Objects.equals(isbn, bookLend.isbn) && Objects.equals(status, bookLend.status) && Objects.equals(lendDate, bookLend.lendDate) && Objects.equals(returnDate, bookLend.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, status, lendDate, returnDate);
    }
}
