package org.parul.pmp.controller;

import org.parul.pmp.entity.Credential;
import org.parul.pmp.repository.CredentialRepository;
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
    private CredentialRepository credentialRepository;
    @GetMapping
    public String login(Model model)
    {
        model.addAttribute("login",new Credential());
        return "login";
    }

    @PostMapping
    public String userLogin(@ModelAttribute("login")Credential login,Model model)
    {
        try
        {
        credentialRepository.saveAndFlush(login);
        model.addAttribute("msg","Successfully Login");
        }
        catch (Exception e)
        {
            model.addAttribute("msg","Not Successfully Login");
        }
        return "Welcome";
    }

}
