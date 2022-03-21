package org.iesfm.library.servicies;

import org.iesfm.library.Member;
import org.iesfm.library.repositories.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean insert(Member member) {
        if(memberRepository.existsById(member.getNif())) {
            return false;
        } else {
            memberRepository.insert(member);
            return true;
        }
    }
}
