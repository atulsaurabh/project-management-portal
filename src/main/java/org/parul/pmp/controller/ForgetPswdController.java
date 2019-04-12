package org.parul.pmp.controller;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.dto.mapper.UserDtoToEntityMapper;
import org.parul.pmp.entity.*;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.StudentRepository;
import org.parul.pmp.repository.UserRepository;
import org.parul.pmp.service.FacultyService;
import org.parul.pmp.service.MailService;
import org.parul.pmp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/forgetpswd")
public class ForgetPswdController
{
    private UserRepository userRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MailService mailService;

    @GetMapping
    public String forgetpswdpg(Model model){
        model.addAttribute("user",new UserDtoToEntityMapper());
        model.addAttribute("student",new StudentDTO());
        model.addAttribute("faculty",new FacultyDTO());
        return "forgetpassword";
    }

    @PostMapping
    public String forgetpswdMailVarification(@ModelAttribute("student") StudentDTO student,@ModelAttribute("faculty") FacultyDTO faculty ,@RequestParam(value = "email") String email, Model model)
    {
        /*try {
            String usermail = email;
            User user = userRepository.findByEmail().get();
            long userid = user.getUserid();
            Credential  credential = user.getCredential();
            String role = String.valueOf(credential.getRoles());
            model.addAttribute("userid",userid);
            if(role == "ROLE_STUDENT")
            {
                MailDTO mailDTO = new MailDTO();
                mailDTO.setUserid(userid);
                mailDTO.setName(student.getFirstname());
                mailDTO.setPassword(student.getPassword());
                mailDTO.setTo(student.getEmail());
                mailDTO.setSubject("Password Reset");
                mailDTO.setLink("\"http://localhost:8080/activate?userid=\"+userid");
                mailService.sendActivationMailWithCredential(mailDTO);
                model.addAttribute("emailId",student.getEmail());
                return "successfulRegistration";

            }
            else if (role == "ROLE_FACULTY")
            {
                MailDTO mailDTO = new MailDTO();
                mailDTO.setUserid(userid);
                mailDTO.setName(faculty.getFacultyFirstname());
                mailDTO.setPassword(faculty.getPassword());
                mailDTO.setTo(faculty.getEmail());
                mailDTO.setSubject("Account Activation");
                mailDTO.setLink("\"http://localhost:8080/activate?userid=\"+userid");
                mailService.sendActivationMailWithCredential(mailDTO);
                model.addAttribute("emailId",faculty.getEmail());
                return "successfulRegistration";


            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }*/
        return "welcome";
    }
}
