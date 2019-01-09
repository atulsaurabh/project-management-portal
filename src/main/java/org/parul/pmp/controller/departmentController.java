package org.parul.pmp.controller;

import org.parul.pmp.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.parul.pmp.repository.departmentRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class departmentController {

    @Autowired
    private departmentRepository departmentRepository;

    @GetMapping
    public String getDepartment(Model model){
        model.addAttribute("department",new Department());
        return "department";
    }

    @PostMapping
    public String registerDepartment(@ModelAttribute("department") Department department, Model model)
    {
        try {

            Department d = departmentRepository.saveAndFlush(department);
            model.addAttribute("message", "Department added successfully");
        }
        catch (Exception e)
        {
            model.addAttribute("message","registration failed");
        }
        return "department";
    }
}
