package org.iesfm.libraryjpa;

import javax.persistence.*;
import java.util.List;

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

    public Book(String isbn, String title, String author, List<String> genres) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genres = genres;
    }

    public Book() {
    }

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
}
