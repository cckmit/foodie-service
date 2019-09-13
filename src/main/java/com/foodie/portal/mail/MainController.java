package com.foodie.portal.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MainController {

    @Autowired
    private MailApplicationService mailApplicationService;

    @RequestMapping("send")
    public void send() {
        mailApplicationService.send("445999306@qq.com","test","test");
    }
}
