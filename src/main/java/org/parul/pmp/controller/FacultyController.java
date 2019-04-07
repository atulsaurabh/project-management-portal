package org.parul.pmp.controller;

import org.parul.pmp.dto.DepartmentDTO;
import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.FacultyProfileDTO;
import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.dto.mapper.DepartmentMapper;
import org.parul.pmp.entity.Department;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.service.FacultyProfileService;
import org.parul.pmp.service.FacultyService;
import org.parul.pmp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private FacultyProfileService facultyProfileService;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private MailService mailService;
    @GetMapping
    public String addFaculty(Model model)
    {
        List<Department> departments= departmentRepository.findAll();
        List<DepartmentDTO> dtos=departments.stream().map(DepartmentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("depts",dtos);
        model.addAttribute("faculty", new FacultyDTO());
        return "faculty";
    }
    @PostMapping
    public String registerFaculty(@ModelAttribute("faculty") FacultyDTO faculty, Model model) {
        try {

            facultyService.addFaculty(faculty);
            //model.addAttribute("msg", "Successful");
            MailDTO mailDTO = new MailDTO();
            mailDTO.setName(faculty.getFaculty_firstname());
            mailDTO.setPassword(faculty.getPassword());
            mailDTO.setTo(faculty.getEmail());
            mailDTO.setSubject("Account Activation");
            mailDTO.setLink("http://localhost:8080/activate");
            mailService.sendActivationMailWithCredential(mailDTO);
            model.addAttribute("emailId",faculty.getEmail());
            return "faculty";

        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("errmsg", "Error");
        }
        return "Welcome";
    }
    @GetMapping("/profile")
    public String addFacultyProfile(Model model)
    {
        model.addAttribute("facultyProfileDTO", new FacultyProfileDTO());
        return "facultyProfile";
    }
    @PostMapping("/profile")
    public String profileOfFaculty(@ModelAttribute("facultyProfileDTO") FacultyProfileDTO facultyProfileDTO, Model model) {
        try {

            facultyProfileService.addFacultyProfile(facultyProfileDTO);
            model.addAttribute("msg", "Successful");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }
        return "Welcome";
    }

}
