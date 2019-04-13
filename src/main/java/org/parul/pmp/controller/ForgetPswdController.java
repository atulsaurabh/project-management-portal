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
import org.parul.pmp.service.MailServiceForForgetPswd;
import org.parul.pmp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/forgetpswd")
public class ForgetPswdController
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MailServiceForForgetPswd mailServiceForForgetPswd;

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
        try
        {

            Student student1 = studentRepository.findByEmail(email).get();
            //Faculty faculty1 = facultyRepository.findByEmail(email).get();

            long stdid = student1.getUserid();
            //long factid = faculty1.getUserid();

            Credential stdcredential = student1.getCredential();
            //Credential factcredential = faculty1.getCredential();

            String stdrole = stdcredential.getRoles().stream().findFirst().get().getName();
            //String factrole = String.valueOf(factcredential.getRoles());

            model.addAttribute("userid",stdid);

            if(stdrole.equals("ROLE_STUDENT"))
            {
                MailDTO mailDTO = new MailDTO();
                mailDTO.setUserid(stdid);
                mailDTO.setName(student.getFirstname());
                mailDTO.setPassword(student.getPassword());
                mailDTO.setTo(student.getEmail());
                mailDTO.setSubject("Password Reset");
                mailDTO.setLink("http://localhost:8080/resetpswd?userid="+stdid);

                mailServiceForForgetPswd.sendResetPasswordMaill(mailDTO);
                model.addAttribute("emailId",student.getEmail());
                return "successfulRegistration";

            }
            /*else if (factrole == "ROLE_FACULTY")
            {
                MailDTO mailDTO = new MailDTO();
                mailDTO.setUserid(factid);
                mailDTO.setName(faculty.getFacultyFirstname());
                mailDTO.setPassword(faculty.getPassword());
                mailDTO.setTo(faculty.getEmail());
                mailDTO.setSubject("Account Activation");
                mailDTO.setLink("\"http://localhost:8080/activate?userid=\"+userid");
                mailService.sendActivationMailWithCredential(mailDTO);
                model.addAttribute("emailId",faculty.getEmail());
                return "successfulRegistration";


            }*/

        }

        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }
        return "welcome";
    }
    @GetMapping("resetpswd")
    public String resetpswd(Model model)
    {
        model.addAttribute("user",new UserDtoToEntityMapper());
        model.addAttribute("student",new StudentDTO());
        model.addAttribute("faculty",new FacultyDTO());

        return "resetpswd";
    }
}
