package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
//조회,저장만 하는 로직
public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public Member save(Member member) {
        em.persist(member);//jpa가 select쿼리 다 만들어서 집어넣어주고, id까지 만들어준다. (모든걸 다 해줌)
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); //(타입,pk값)넣어주면 조회해준다.
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result =em.createQuery("select m from Member m where m.name =:name",Member.class)
                .setParameter("name",name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
    return em.createQuery("select m from Member m", Member.class)//Member entity를 조회 as는 생략,  select할때 객체자체를 선택할수있다.(특이한점)
        .getResultList();
    }
}
