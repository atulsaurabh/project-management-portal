package org.parul.pmp.service.util;

import org.parul.pmp.dto.MailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class MailContentBuilderUtilForGroupRequest {
    @Autowired
    private TemplateEngine templateEngine;
    public String buildMessage(MailDTO dto)
    {
        Context context = new Context();
        context.setVariable("mail",dto);
        return templateEngine.process("mailtemplateforgroupmember",context);
    }
}
