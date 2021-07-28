package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//시스템이 정하는 id,구분하기위한한

    @Column
    private String name;

}
