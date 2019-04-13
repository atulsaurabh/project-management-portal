package org.parul.pmp.service;

import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.service.util.MailContentBuilderUtilForForgetPswd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailServiceForForgetPswd {

    @Value("spring.mail.username")
    private String email;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailContentBuilderUtilForForgetPswd mailContentBuilderUtilForForgetPswd;

    public void sendResetPasswordMaill(MailDTO mailDTO)
    {
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(email);
            mimeMessageHelper.setTo(mailDTO.getTo());
            mimeMessageHelper.setSubject(mailDTO.getSubject());
            String content = mailContentBuilderUtilForForgetPswd.buildMessage(mailDTO);
            mimeMessageHelper.setText(content,true);
        };
        javaMailSender.send(mimeMessagePreparator);
    }





}
