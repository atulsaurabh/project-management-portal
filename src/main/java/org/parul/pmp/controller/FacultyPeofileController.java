package org.parul.pmp.controller;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.FacultyProfileDTO;
import org.parul.pmp.service.FacultyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faculty")
public class FacultyPeofileController {

    @Autowired
    private  FacultyProfileService facultyProfileService;
    @GetMapping
    public String getFacultyAddPage(Model model)
    {
        model.addAttribute("faculty",new FacultyProfileDTO());
        return "facultyProfile";
    }


    @PostMapping("profile")
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
