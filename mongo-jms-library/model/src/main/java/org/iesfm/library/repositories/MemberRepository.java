package org.iesfm.library.repositories;

import org.iesfm.library.BookLend;
import org.iesfm.library.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberRepository extends MongoRepository<Member, String> {

    List<BookLend> findMemberLendsByNif(String nif);
}
