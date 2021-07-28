package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberservice;


    public MemberController(MemberService memberservice) {
        this.memberservice = memberservice;
    }

    @GetMapping("/members/new")
    public String createForm(){//회원가입폼띄우기
        return "members/createMemberForm";
    }

    @PostMapping("members/new")//MemberForm의 name에 html의 name이 넣어진다.
    public String create(MemberForm form){//회원이 새로생성
        Member member = new Member();
        member.setName(form.getName());

        memberservice.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberservice.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
