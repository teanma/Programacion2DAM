package org.iesfm.libraryjpa.repository;

import org.iesfm.libraryjpa.BookLend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLendRepository extends JpaRepository<BookLend, Integer> {

    @Query(
            value = "SELECT b.* FROM book_lend b INNER JOIN member m ON m.member_id=b.id WHERE nif=?",
            nativeQuery = true
    )

    List<BookLend> findMemberBookLendByNif(String memberNif);
}
