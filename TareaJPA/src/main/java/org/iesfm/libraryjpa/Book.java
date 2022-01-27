package org.iesfm.libraryjpa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
    private String title;
    private String author;
    @ElementCollection
    @CollectionTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    )
    @Column(name = "genre")
    private List<String> genres;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genres, book.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, genres);
    }
}
