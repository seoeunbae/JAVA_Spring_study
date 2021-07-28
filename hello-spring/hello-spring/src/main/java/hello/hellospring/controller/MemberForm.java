package hello.hellospring.controller;

public class MemberForm {
    public String getName() {
        return name;
    }

    public void setName(String name) {//set땡떙의 떙떙이 html의 name와 같아야함(앞글자는 대문자처리)
        this.name = name;
    }

    private String name;
}
