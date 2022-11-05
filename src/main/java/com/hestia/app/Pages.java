package com.hestia.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pages {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("descriptions", new String[]{"hello", "hello2"});
        return "dashboard";
    }

}
