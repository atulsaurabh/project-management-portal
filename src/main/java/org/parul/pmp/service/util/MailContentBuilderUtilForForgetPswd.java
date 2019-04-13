package org.parul.pmp.service.util;

import org.parul.pmp.dto.MailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class MailContentBuilderUtilForForgetPswd {


    @Autowired
    private TemplateEngine templateEngine;

    public String buildMessage(MailDTO dto)
    {
        Context context = new Context();
        context.setVariable("mail",dto);
        return templateEngine.process("forgetpswdmailtemplate",context);
    }


}
