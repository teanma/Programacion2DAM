package org.iesfm.library.api.controllers.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BookLendApi {

    private String isbn;
    private String status;
    private String lendDate;
    private String returnDate;

    @JsonCreator
    public BookLendApi(
            @JsonProperty("isbn") String isbn,
            @JsonProperty("status") String status,
            @JsonProperty("lendDate") String lendDate,
            @JsonProperty("returnDate") String returnDate) {
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
        BookLendApi that = (BookLendApi) o;
        return Objects.equals(isbn, that.isbn) && Objects.equals(status, that.status) && Objects.equals(lendDate, that.lendDate) && Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, status, lendDate, returnDate);
    }
}
