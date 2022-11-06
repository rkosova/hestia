package com.hestia.app.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("api/v1/mail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendMail")
    public RedirectView sendMail(EmailDetails details)
    {
        emailService.sendSimpleMail(details);
        return new RedirectView("/dashboard");
    }
}
