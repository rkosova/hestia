package com.hestia.app;

import com.hestia.app.project.ProjectRepository;
import com.hestia.app.skill.SkillRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Pages {

    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;

    public Pages(ProjectRepository projectRepository, SkillRepository skillRepository) {
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        if(session.getAttribute("user") == null){return "redirect:/login";}
        model.addAttribute("projects", projectRepository.findAll());
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(HttpSession session) {
        if(session.getAttribute("user")!= null){return "redirect:/";}
        return "login";
    }

    @GetMapping("/register")
    public String register(HttpSession session) {
        if(session.getAttribute("user")!= null){return "redirect:/";}
        return "register";
    }

    @GetMapping("/test")
    public String test(HttpSession session) {

        return (String) session.getAttribute("user");
    }

    @GetMapping("/new_project")
    public String project(Model model, HttpSession session) {

        if(session.getAttribute("user") == null){return "redirect:/login";}
        model.addAttribute("skills", skillRepository.findAll());
        return "newProject";
    }

}
