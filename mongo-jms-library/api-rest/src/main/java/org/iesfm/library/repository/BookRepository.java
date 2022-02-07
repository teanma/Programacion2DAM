package org.iesfm.library.repository;

import org.iesfm.library.pojos.Book;
import org.iesfm.library.pojos.BookLend;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookRepository extends MongoRepository<Book, String> {

    List<BookLend> findLendedBooksByNif(String nif);

}
