package hello.hellospring.domain;

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

    private Long id;//시스템이 정하는 id,구분하기위한한
    private String name;

}
