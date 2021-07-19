package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {//레포지토리를 외부에서 넣어주도록 DI(Depedency Injection)
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){

        validateDuplicatedMember(member);//중복회원검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(me -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
//전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
