package org.iesfm.libraryjpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "book_genre")
public class BookGenre {

    @Id
    @Column(nullable = false)
    private String isbn;
    @Id
    @Column(nullable = false)
    private String genre;

    public BookGenre(String isbn, String genre) {
        this.isbn = isbn;
        this.genre = genre;
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
        BookGenre bookGenre = (BookGenre) o;
        return Objects.equals(isbn, bookGenre.isbn) &&
                Objects.equals(genre, bookGenre.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, genre);
    }
}
