package org.parul.pmp.controller;

import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.entity.*;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.StudentRepository;
import org.parul.pmp.repository.UserRepository;
import org.parul.pmp.service.MailServiceForForgetPswd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller

public class ForgetPswdController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MailServiceForForgetPswd mailServiceForForgetPswd;

    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public ModelAndView displayForgotPasswordPage(Model model)
    {
        return new ModelAndView("forgetpassword");
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, Model model,
                                                  @RequestParam("email") String email,
                                                  HttpServletRequest request,
                                                  HttpSession session) {
        Optional<Student> student = studentRepository.findByEmail(email);
        //Faculty faculty1 = facultyRepository.findByEmail(email).get();

        Long stdid = (Long) session.getAttribute("userid");
        //long factid = faculty1.getUserid();

        Credential stdcredential = student.get().getCredential();
        //Credential factcredential = faculty1.getCredential();

        String stdrole = stdcredential.getRoles().stream().findFirst().get().getName();
        //String factrole = String.valueOf(factcredential.getRoles());

        model.addAttribute("userid", stdid);

        if (!student.isPresent())
        {
            modelAndView.addObject("errmsg", "We didn't find an account for that e-mail address.");
        }
        else
        {
            Student student1 = student.get();
            student1.setToken(UUID.randomUUID().toString());
            studentRepository.save(student1);

            if (stdrole.equals("ROLE_STUDENT"))
            {
                MailDTO mailDTO = new MailDTO();
                //mailDTO.setUserid(stdid);
                mailDTO.setName(student.get().getFirstname());
                mailDTO.setPassword(student.get().getPassword());
                mailDTO.setTo(student.get().getEmail());
                mailDTO.setSubject("Password Reset");
                mailDTO.setLink("http://localhost:8080/resetpassword?token=" + student1.getToken());

                mailServiceForForgetPswd.sendResetPasswordMaill(mailDTO);
                model.addAttribute("emailId", student.get().getEmail());
                modelAndView.addObject("msg", "A password reset link has been sent to " + email);

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
        modelAndView.setViewName("forgetpassword");
        return modelAndView;

    }
    /*@GetMapping("/reset")
    public String resetpswd(Model model)
    {
        model.addAttribute("user",new UserDtoToEntityMapper());
        model.addAttribute("student",new StudentDTO());
        model.addAttribute("faculty",new FacultyDTO());

        return "resetpswd";
    }*/

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public ModelAndView displayResetPasswordPage(ModelAndView modelAndView,
                                                 @RequestParam("token") String token)
    {
        Optional<Student> student = studentRepository.findByToken(token);
        if (student.isPresent()) { // Token found in DB
            modelAndView.addObject("resetToken", token);
        } else { // Token not found in DB
            modelAndView.addObject("errmsg", "Oops!  This is an invalid password reset link.");
        }
        modelAndView.setViewName("resetpassword");
        return modelAndView;
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public ModelAndView setNewPassword(ModelAndView modelAndView,
                                       @RequestParam Map<String, String> requestParams,
                                       RedirectAttributes redir)
    {
        Optional<Student> student = studentRepository.findByToken(requestParams.get("token"));
        if (student.isPresent()) {

            Student resetUser = student.get();
            resetUser.setPassword(requestParams.get("password"));
            resetUser.setToken(null);
            studentRepository.saveAndFlush(resetUser);
            redir.addFlashAttribute("msg", "You have successfully reset your password.  You may now login.");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        else {
            modelAndView.addObject("errmsg", "Oops!  This is an invalid password reset link.");
            modelAndView.setViewName("resetpassword");
        }
        return modelAndView;
    }

}