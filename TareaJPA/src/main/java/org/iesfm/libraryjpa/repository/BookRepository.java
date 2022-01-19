package org.iesfm.libraryjpa.repository;

import org.iesfm.libraryjpa.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findBookByAuthor(String author);

    @Query(
            value = "SELECT b.* FROM book b INNER JOIN book_lend bl ON bl.isbn=b.isbn",
            nativeQuery = true
    )

    List<Book> findAllLendedBooks();
}
