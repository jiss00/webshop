package phj.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import phj.webshop.domain.Member;

@Controller
public class HelloController {
    @GetMapping("login")
    public String log(Model model){
        return "login";
    }
}


