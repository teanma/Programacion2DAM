package org.iesfm.libraryjpa.repository;

import org.iesfm.libraryjpa.BookLend;
import org.iesfm.libraryjpa.BookLendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLendRepository extends JpaRepository<BookLend, BookLendId> {

    @Query(
            value = "SELECT b.* FROM book_lend b INNER JOIN member m ON m.id=b.member_id WHERE nif=?",
            nativeQuery = true
    )

    List<BookLend> findMemberBookLendByNif(String memberNif);
}
