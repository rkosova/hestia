package com.hestia.app;


import com.hestia.app.mail.EmailController;
import com.hestia.app.mail.EmailDetails;
import com.hestia.app.mail.EmailServiceImpl;
import com.hestia.app.mail.MailDefault;
import com.hestia.app.project.ProjectRepository;
import com.hestia.app.skill.SkillRepository;
import com.hestia.app.user.User;
import com.hestia.app.user.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class Pages {
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;

    public Pages(ProjectRepository projectRepository, SkillRepository skillRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        if(session.getAttribute("user") == null){return "redirect:/login";}
        model.addAttribute("projects", projectRepository.findAll());
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(HttpSession session) {
        if(session.getAttribute("user")!= null){return "redirect:/dashboard";}
        return "login";
    }

    @GetMapping("/register")
    public String register(HttpSession session) {
        if(session.getAttribute("user")!= null){return "redirect:/dashboard";}
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
        Optional<User> user = userRepository.findAllByEmail((String)session.getAttribute("user"));
        if (user.isPresent()) {
            model.addAttribute("id", user.get().getId());
        }

        return "newProject";
    }
    @GetMapping("/sendMail")
    public String sendMail(){
        return "mail";
    }

    @GetMapping("/mail/{id}")
    public String mail(HttpSession session, @PathVariable Long id) {
        if(session.getAttribute("user") != null){
            String email =projectRepository.findById(id).get().getUser().getEmail();
            EmailDetails details = new EmailDetails(email,
                    MailDefault.defaultBody((String)session.getAttribute("user")),
                    "Project companion");
            return "redirect:http://localhost:8080/api/v1/mail/sendMail?recipient="+email+"&subject=Project companion"+"&msgBody="+MailDefault.defaultBody((String)session.getAttribute("user"));
        }

        return "dashboard";
    }

}
