package org.parul.pmp.service;

import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.service.util.MailContentBuilderUtil;
import org.parul.pmp.service.util.MailContentBuilderUtilForGroupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class Mailserviceforgroup {
    @Value("spring.mail.username")
    private String email;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailContentBuilderUtilForGroupRequest mailContentBuilderUtilForGroupRequest;

    public void sendActivationMailWithCredential(MailDTO mailDTO)
    {
        //MimeMessageHelper helper=new MimeMessageHelper();
        //MimeMailMessage mimeMailMessage= new MimeMailMessage
        /*MimeMailMessage mailMessage = new MimeMailMessage(javaMailSender.createMimeMessage());
        mailMessage.setFrom(email);
        mailMessage.setTo(mailDTO.getTo());
        mailMessage.setSubject(mailDTO.getSubject());
        mailMessage.setText(mailDTO.activationMessage());
        javaMailSender.send(mailMessage.getMimeMessage());*/

        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(email);
            mimeMessageHelper.setTo(mailDTO.getTo());
            mimeMessageHelper.setSubject(mailDTO.getSubject());
            String content = mailContentBuilderUtilForGroupRequest.buildMessage(mailDTO);
            mimeMessageHelper.setText(content,true);
        };
        javaMailSender.send(mimeMessagePreparator);

    }
}
