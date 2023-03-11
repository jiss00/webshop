package phj.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import phj.webshop.domain.Member;
import phj.webshop.repository.MemoryMemberRepository;
import phj.webshop.service.MemberService;

@Controller
public class LoginController {
    private MemoryMemberRepository repository;
    private MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Autowired
    public LoginController(MemoryMemberRepository repository) {
        this.repository = repository;
    }

    @GetMapping("login")
    public String log(Model model){
        return "login";
    }

    @PostMapping(value = "login")
    public String check(MemberForm memberForm){
        if(memberService.login(memberForm.getId(), memberForm.getPw())) {return "redirect:/";}
        else return "login_fail";
    }
    @GetMapping("login_fail")
    public String fail(){
        return "login_fail";
    }
}


