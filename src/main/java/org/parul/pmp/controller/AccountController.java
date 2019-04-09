package org.parul.pmp.controller;

import org.parul.pmp.dto.LoginDTO;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.User;
import org.parul.pmp.exception.UserNotExistException;
import org.parul.pmp.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController
{

    @Autowired
    private AcountService acountService;
    @GetMapping("/login")
    public String loginpage(Model model)
    {
        model.addAttribute("loginDTO",new LoginDTO());
        return "userLogin";
    }
    @PostMapping("/login")
    public String login(LoginDTO loginDTO, Model model, HttpSession session) throws UserNotExistException
    {
        Credential credential =acountService.performLoginAndFetchRole(loginDTO);
        User user =credential.getUser();
        session.setAttribute("userid",credential.getUser().getUserid());
        String rolename=credential.getRoles().stream().findFirst().get().getName();
        String uiname="";
        switch (rolename)
        {
            case "ROLE_HOD":
                uiname="hodHomePage";
                break;
            case "ROLE_COLLEGE_ADMIN":
                uiname="collegeAdmin";
                break;
            case "ROLE_UNIVERSITY_ADMIN":
                uiname="universityAdmin";
                break;
            case "ROLE_FACULTY":
                uiname="facultyHome";
                break;
            case "ROLE_STUDENT":
                if(user.isActivate())
                {
                    uiname="studenthome";
                }
                else {
                    model.addAttribute("msg","check your account is activated or not");
                }

        }
        model.addAttribute("username",credential.getUsername());
        return uiname;
    }
}

