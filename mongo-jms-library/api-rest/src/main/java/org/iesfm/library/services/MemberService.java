package org.iesfm.library.services;

import org.iesfm.library.exceptions.MemberNotFoundException;
import org.iesfm.library.pojos.BookLend;
import org.iesfm.library.pojos.Member;
import org.iesfm.library.repository.BookRepository;
import org.iesfm.library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    private BookRepository bookRepository;

    public MemberService(MemberRepository memberRepository, BookRepository bookRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public boolean insert(Member member) {
        if(memberRepository.existsById(member.getNif())) {
            return true;
        }
        memberRepository.insert(member);
        return true;
    }

    public List<Member> list() {
        return memberRepository.findAll();
    }

    public List<BookLend> memberBookLends(String nif) throws MemberNotFoundException {
        if(!memberRepository.existsById(nif)) {
            throw new MemberNotFoundException(nif);
        }
        return memberRepository.findMemberLendsByNif(nif);
    }

    public void addBooklend(String isbn, String nif, BookLend bookLend) {
        //Optional<Member> member = memberRepository.findById(nif);
    }
}
