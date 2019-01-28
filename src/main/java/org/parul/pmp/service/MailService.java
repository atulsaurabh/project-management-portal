package org.parul.pmp.service;

import org.parul.pmp.dto.MailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService
{

    @Value("spring.mail.username")
    private String email;
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendActivationMailWithCredential(MailDTO mailDTO)
    {
        //MimeMessageHelper helper=new MimeMessageHelper();
        //MimeMailMessage mimeMailMessage= new MimeMailMessage
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(email);
        mailMessage.setTo(mailDTO.getTo());
        mailMessage.setSubject(mailDTO.getSubject());
        mailMessage.setText(mailDTO.activationMessage());
        javaMailSender.send(mailMessage);
    }

    public void setEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }
}
