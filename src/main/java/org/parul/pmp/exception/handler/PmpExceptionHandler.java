package org.parul.pmp.exception.handler;

import org.parul.pmp.exception.SessionExpiredException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PmpExceptionHandler {

    @ExceptionHandler(SessionExpiredException.class)
    public String handleSessionExpiredException(SessionExpiredException sessionExpired, Model model)
    {
        model.addAttribute("errmsg","your session has bedd expired. kindly login again");
        return "sessionexpire";
    }
}
