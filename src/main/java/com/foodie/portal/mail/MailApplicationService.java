package com.foodie.portal.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailApplicationService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    public void send(String to, String subject, String content) {
        log.info("mail to : {}\n subject is: {}\n content is: {}", to, subject, content);
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom(mailSender.getUsername());
        simpleMessage.setTo(to);
        simpleMessage.setSubject(subject);
        simpleMessage.setText(content);
        mailSender.send(simpleMessage);

    }
}
