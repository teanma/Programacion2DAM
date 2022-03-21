package org.iesfm.library.repositories;

import org.iesfm.library.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findLendedBooksByNif(String nif);

}
