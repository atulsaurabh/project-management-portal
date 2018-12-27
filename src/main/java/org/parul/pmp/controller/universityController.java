package org.parul.pmp.controller;

import org.parul.pmp.dto.university;
import org.parul.pmp.repository.universityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/universityregister")
public class universityController {
    @Autowired
    private universityRepository universityRepository;
    @GetMapping
    public String addUniversityPage(Model model)
    {
        model.addAttribute("university", new university() );
        return "university";
    }
   @PostMapping
    public String registerUniversity(@ModelAttribute("university")university university, Model model) {
        try {
            universityRepository.saveAndFlush(university);
            model.addAttribute("msg", "Successful");
        }
        catch (Exception e)
        {
            model.addAttribute("msg", "Error");
        }
        return "university";
        }
    }


