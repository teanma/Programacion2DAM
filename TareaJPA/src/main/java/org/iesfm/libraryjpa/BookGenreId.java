package org.iesfm.libraryjpa;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BookGenreId implements Serializable {

    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
    private String genre;

    public BookGenreId(String isbn, String genre) {
        this.isbn = isbn;
        this.genre = genre;
    }

    public BookGenreId() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookGenreId that = (BookGenreId) o;
        return Objects.equals(isbn, that.isbn) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, genre);
    }
}
