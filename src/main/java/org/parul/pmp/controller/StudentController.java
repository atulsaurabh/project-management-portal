package org.parul.pmp.controller;

import org.parul.pmp.dto.*;
import org.parul.pmp.dto.mapper.CollegeMapper;
import org.parul.pmp.dto.mapper.DepartmentMapper;
import org.parul.pmp.dto.mapper.UniversityMapper;
import org.parul.pmp.entity.College;
import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.University;
import org.parul.pmp.repository.CollegeRepository;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.repository.UniversityRepository;
import org.parul.pmp.service.MailService;
import org.parul.pmp.service.StudentProfileService;
import org.parul.pmp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentProfileService studentProfileService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private MailService mailService;

    @GetMapping("/register")
    public String addStudent(Model model)
    {
        List<University> universities=universityRepository.findAll();
        List<UniversityDTO> unidtos=universities.stream().map(UniversityMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("univercities",unidtos);
        List<College> colleges= collegeRepository.findAll();
        List<CollegeDTO> clgdtos=colleges.stream().map(CollegeMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("colleges",clgdtos);
        List<Department> departments= departmentRepository.findAll();
        List<DepartmentDTO> dtos=departments.stream().map(DepartmentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("depts",dtos);
        model.addAttribute("student",new StudentDTO());
        return "student";
    }

    @PostMapping("/register")
    public String pmpMember(@ModelAttribute("student") StudentDTO student, Model model)
    {
        try {

            studentService.addStudent(student);
           // model.addAttribute("msg", "Successful");
            MailDTO mailDTO = new MailDTO();
            mailDTO.setName(student.getFirstname());
            mailDTO.setPassword(student.getPassword());
            mailDTO.setTo(student.getEmail());
            mailDTO.setSubject("Account Activation");
            mailDTO.setLink("http://localhost:8080/activate");
            mailService.sendActivationMailWithCredential(mailDTO);
            model.addAttribute("emailId",student.getEmail());
            return "successfulRegistration";

        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }
        return "Welcome";
    }

    @GetMapping("/profile")
    public String addProfile(Model model){
        model.addAttribute("profileDTO",new StudentProfileDTO());
        return "StudentProfile";
    }

    @PostMapping("/profile")
    public String pmpProfile(@ModelAttribute("profileDTO") StudentProfileDTO profileDTO, Model model)
    {
        try {

            studentProfileService.addStudentProfile(profileDTO);
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
