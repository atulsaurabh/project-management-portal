package org.parul.pmp.controller;

import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController
{
    @Autowired
    private MailService mailService;
    @GetMapping
    public String sendMail()
    {
        MailDTO mailDTO = new MailDTO();
        mailDTO.setName("Atul Saurabh");
        mailDTO.setPassword("123");
        mailDTO.setTo("atul.saurabh@gmail.com");
        mailDTO.setSubject("Account Activation");
        mailDTO.setLink("http://localhost:8080/activate");
        mailService.sendActivationMailWithCredential(mailDTO);
        return "abc";
    }
}
