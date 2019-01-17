package org.parul.pmp.controller;

import org.parul.pmp.dto.CollegeDTO;
import org.parul.pmp.dto.DepartmentDTO;
import org.parul.pmp.dto.mapper.DepartmentMapper;
import org.parul.pmp.entity.College;
import org.parul.pmp.entity.Department;
import org.parul.pmp.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.parul.pmp.repository.DepartmentRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;



    @GetMapping
    public String getDepartment(Model model){

        model.addAttribute("department",new Department());
        return "department";
    }

    @PostMapping
    public String addDepartment(@ModelAttribute("department") Department department, Model model)
    {
        try {

            departmentRepository.saveAndFlush(department);
            model.addAttribute("message", "Department added successfully");
        }
        catch (Exception e)
        {
            model.addAttribute("message","registration failed");
        }
        return "Welcome";
    }
}
