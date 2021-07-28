package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
//여기의 역할은 뭘까?
@Configuration
public class SpringConfig {

    public SpringConfig(MemberRepository memberRepository) {//springdatajpa가 만들어놓은거가 등록됨
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository;

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////            return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }
    //interface만 extends해서 만들어놓으면 interface에 대한 구현체를 스스로 만들어서 빈에 등록까지한다. 그래서 위코드는 필요없음

}
