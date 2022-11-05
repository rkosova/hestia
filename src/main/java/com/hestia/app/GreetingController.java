package com.hestia.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/post")
    public String post(Model model,String name) {
        model.addAttribute("name",name);
        return "post";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

}
