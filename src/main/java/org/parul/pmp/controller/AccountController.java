package org.parul.pmp.controller;

import org.parul.pmp.dto.LoginDTO;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.exception.UserNotExistException;
import org.parul.pmp.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController
{

    @Autowired
    private AcountService acountService;
    @GetMapping
    public String loginpage(Model model)
    {
        model.addAttribute("loginDTO",new LoginDTO());
        return "login";
    }
    @PostMapping("/login")
    public String login(LoginDTO loginDTO, Model model) throws UserNotExistException
    {
        Credential credential =acountService.performLoginAndFetchRole(loginDTO);
        String rolename=credential.getRoles().stream().findFirst().get().getName();
        String uiname="";
        switch (rolename)
        {
            case "ROLE_ADMIN":
                uiname="admin";
                break;
            case "ROLE_SUPER_ADMIN":
                uiname="superadmin";
                break;
            case "ROLE_UNIVERSITY_ADMIN":
                uiname="registerMember";
                break;
        }
        model.addAttribute("username",credential.getUsername());
        return uiname;
    }
}

