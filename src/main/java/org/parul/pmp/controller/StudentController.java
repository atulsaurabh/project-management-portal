package org.parul.pmp.controller;

import org.parul.pmp.dto.DepartmentDTO;
import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.dto.StudentProfileDTO;
import org.parul.pmp.dto.mapper.DepartmentMapper;
import org.parul.pmp.entity.Department;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.service.StudentProfileService;
import org.parul.pmp.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentProfileService studentProfileService;
    @Autowired
    private DepartmentRepository departmentReposit;

    @GetMapping("/register")
    public String addStudent(Model model)
    {
        List<Department> departments= departmentReposit.findAll();
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
            model.addAttribute("msg", "Successful");

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
