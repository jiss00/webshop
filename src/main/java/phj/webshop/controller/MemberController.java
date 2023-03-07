package phj.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import phj.webshop.domain.Member;
import phj.webshop.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("join") //회원을 조회하는 느낌일 때 사용
    public String join(Model model) {
        return "join";
    }

    @PostMapping(value = "join") //회원을 등록하는 느낌일 때 사용
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setId(form.getId());
        member.setPw(form.getPw());
        member.setTel(form.getTel());
        member.setAddress(form.getAddress());

        memberService.join(member);

        return "redirect:/"; //홈화면으로 보내는것.
    }

    @GetMapping("members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "memberList";
    }
}
