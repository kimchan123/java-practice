package com.woowacourse.transaction;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostConstruct
    public void setUp() {
        memberRepository.save(new Member("test1"));
        memberRepository.save(new Member("test2"));
    }

    public Member findMember(final Long id) {
        return memberRepository.findById(id).get();
    }

    public void changeName(final Long id, final String name) {
        Member member = findMember(id);
        member.changeName(name);
    }
}
