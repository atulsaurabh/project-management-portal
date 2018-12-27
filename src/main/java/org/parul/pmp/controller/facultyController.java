package org.parul.pmp.controller;

import org.parul.pmp.dto.faculty;
import org.parul.pmp.repository.facultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faculty")
public class facultyController {

    @Autowired
    private facultyRepository faculty_repository;

    @GetMapping
    public String getFacultyAddPage(Model model)
    {
        model.addAttribute("faculty",new faculty());
        return "Faculty";
    }


    @PostMapping
    public String Add_faculty(@ModelAttribute("faculty")faculty faculty, Model model)
    {
        try
        {
            faculty f = faculty_repository.saveAndFlush(faculty);
            model.addAttribute("message","Faculty added successfully");
        }
        catch (Exception e)
        {
            model.addAttribute("message","Faculty not added");
        }

        return "Faculty";
    }
}
