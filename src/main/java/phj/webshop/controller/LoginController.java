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
    private MemoryMemberRepository memoryMemberRepository;
    private MemberService memberService;
    @Autowired
    public LoginController(MemoryMemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }

    @GetMapping("login")
    public String log(Model model){
        return "login";
    }

    @PostMapping(value = "login")
    public String check(String Id,String Pw){
        if(memberService.login(Id, Pw)) return "redirect:/";
        else return "login_fail";
    }
}


