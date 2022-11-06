package com.hestia.app.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {


    @Value("${spring.mail.username}") private String sender;

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendSimpleMail(EmailDetails details) {

            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
            System.out.println(mailMessage);
            javaMailSender.send(mailMessage);

    }
}

