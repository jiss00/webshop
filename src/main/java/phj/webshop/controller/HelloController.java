package phj.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("login")
    public String log(Model model){
        return "login";
    }
    @GetMapping("join")
    public String join(Model model){
        return "join";
    }

}
