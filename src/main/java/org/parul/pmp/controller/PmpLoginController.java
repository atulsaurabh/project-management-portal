package org.parul.pmp.controller;

import org.parul.pmp.entity.PmpLogin;
import org.parul.pmp.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class PmpLoginController {
    @Autowired
    private LoginRepository loginRepository;
    @GetMapping
    public String login(Model model)
    {
        model.addAttribute("pmpLogin",new PmpLogin());
        return "login";
    }

    @PostMapping
    public String userLogin(@ModelAttribute("pmpLogin")PmpLogin pmpLogin,Model model)
    {
        try
        {
        loginRepository.saveAndFlush(pmpLogin);
        model.addAttribute("msg","Successfully Login");
        }
        catch (Exception e)
        {
            model.addAttribute("msg","Not Successfully Login");
        }
        return "Welcome";
    }

}
