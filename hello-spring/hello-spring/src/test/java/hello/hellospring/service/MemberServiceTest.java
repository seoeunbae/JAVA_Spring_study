package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;//new 를 통해생성하면, 문제: MemberService에서 만든 MemoryMemberRepository랑 MemberServiceTest의 MemoryMemberRepository랑 다른 객체,다른DB...!같은 레퍼지토리로 테스트해야함원래는

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); //
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void DuplicatedMemberException(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 = new Member();
        member2.setName("spring1");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//.class가 뭘까

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try{
//            memberService.join(member2);
//            fail(); //에러가 발생하면 fail()이 호출되지 않고 catch절로 넘어간다
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}