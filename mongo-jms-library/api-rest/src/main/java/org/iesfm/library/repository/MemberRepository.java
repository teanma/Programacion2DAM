package org.iesfm.library.repository;

import org.iesfm.library.pojos.BookLend;
import org.iesfm.library.pojos.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberRepository extends MongoRepository<Member, String> {

    List<BookLend> findMemberLendsByNif(String nif);
}
