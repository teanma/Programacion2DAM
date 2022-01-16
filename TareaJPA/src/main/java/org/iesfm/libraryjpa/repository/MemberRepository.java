package org.iesfm.libraryjpa.repository;

import org.iesfm.libraryjpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    List<Member> findMembersByName(String name);
    int deleteByNameAndSurname(String name, String surname);
}
