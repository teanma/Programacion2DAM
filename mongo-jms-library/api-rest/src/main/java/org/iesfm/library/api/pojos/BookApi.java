package org.iesfm.library.api.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class BookApi {

    private String isbn;
    private String title;
    private String author;
    private List<String> genres;

    @JsonCreator
    public BookApi(
            @JsonProperty("isbn") String isbn,
            @JsonProperty("title") String title,
            @JsonProperty("author") String author,
            @JsonProperty("genres") List<String> genres) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genres = genres;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookApi bookApi = (BookApi) o;
        return Objects.equals(isbn, bookApi.isbn) && Objects.equals(title, bookApi.title) && Objects.equals(author, bookApi.author) && Objects.equals(genres, bookApi.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, genres);
    }


}
