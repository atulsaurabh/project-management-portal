package org.parul.pmp.controller;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.LoginDTO;
import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.User;
import org.parul.pmp.entity.enumeration.Roles;
import org.parul.pmp.exception.UserNotExistException;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.service.AcountService;
import org.parul.pmp.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/account")
public class AccountController
{

    @Autowired
    private AcountService acountService;
    @Autowired
    private FacultyRepository facultyRepository;

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
        session.setAttribute("userid",credential.getUser().getUserid());
        String rolename=credential.getRoles().stream().findFirst().get().getName();
        String uiname="";
        switch (rolename)
        {
//            case "ROLE_HOD":
//                uiname="hodHomePage";
//                break;
            case "ROLE_COLLEGE_ADMIN":
                uiname="collegeAdmin";
                break;
            case "ROLE_UNIVERSITY_ADMIN":
                uiname="universityAdmin";
                break;
            case "ROLE_FACULTY":
                Optional<Faculty> faculty = facultyRepository.findById(credential.getUser().getUserid());
                if (faculty.get().isHod())
                    uiname="hodHomePage";
                else
                    uiname="pqr";
                break;
            case "ROLE_STUDENT":
                uiname="studenthome";

        }
        model.addAttribute("username",credential.getUsername());
        return uiname;
    }
}

