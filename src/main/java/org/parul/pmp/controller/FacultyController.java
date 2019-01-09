package org.parul.pmp.controller;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.FacultyProfileDTO;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.service.FacultyProfileService;
import org.parul.pmp.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;
    @Autowired
    private FacultyProfileService facultyProfileService;

    @GetMapping
    public String getFacultyAddPage(Model model)
    {
        model.addAttribute("faculty",new FacultyDTO());
        return "faculty";
    }


    @PostMapping
    public String Add_faculty(@ModelAttribute("faculty") FacultyDTO faculty, Model model)
    {
        try
        {
            facultyService.addFaculty(faculty);
            model.addAttribute("message","Faculty added successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("message","Faculty not added");
        }

        return "Welcome";
    }

    @GetMapping("/profile")
    public String getFacultyProfileAddPage(Model model)
    {
        model.addAttribute("faculty",new FacultyProfileDTO());
        return "facultyProfile";
    }

    @PostMapping("/profile")
    public String Add_faculty(@ModelAttribute("faculty") FacultyProfileDTO faculty, Model model)
    {
        try
        {
            facultyProfileService.addFacultyProfile(faculty);
            model.addAttribute("message","Faculty added successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("message","Faculty not added");
        }

        return "Welcome";
    }
}
