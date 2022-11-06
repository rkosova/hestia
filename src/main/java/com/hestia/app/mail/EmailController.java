package com.hestia.app.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/mail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping ("/sendMail")
    public String sendMail(@ModelAttribute EmailDetails details)
    {

        emailService.sendSimpleMail(details);
        return "";
    }
}
