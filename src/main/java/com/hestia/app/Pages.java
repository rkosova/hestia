package com.hestia.app;

import com.hestia.app.project.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Pages {

    private final ProjectRepository projectRepository;

    public Pages(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        model.addAttribute("projects", projectRepository.findAll());
        return "dashboard";

    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/test")
    public String test(HttpSession session) {

        return (String) session.getAttribute("user");
    }


}
