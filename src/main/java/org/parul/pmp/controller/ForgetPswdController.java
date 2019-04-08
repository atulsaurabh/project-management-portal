package org.parul.pmp.controller;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.dto.mapper.UserDtoToEntityMapper;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.Student;
import org.parul.pmp.entity.User;
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
    public String forgetpswdMailVarification(@RequestParam(value = "email") String email, Model model)
    {
        try {
           // User user = userRepository.findByEmail(email).get();
            Faculty faculty1=facultyRepository.findByEmail(email).get();
//            Optional<Faculty> facultyOptional=faculty1.getDepartment().getFaculties().stream().filter(faculty -> {
//                return faculty.getEmail();
//            }).findFirst();
//            if (faculty1.isPresent)
//            {
                MailDTO mailDTO = new MailDTO();
                mailDTO.setName(faculty1.getFacultyFirstname());
                mailDTO.setPassword(faculty1.getPassword());
                mailDTO.setTo(faculty1.getEmail());
                mailDTO.setSubject("Account Activation");
                mailDTO.setLink("http://localhost:8080/activate");
                mailService.sendActivationMailWithCredential(mailDTO);
                model.addAttribute("emailId",faculty1.getEmail());
                return "successfulRegistration";


        }

        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }
        return "";
    }
}
