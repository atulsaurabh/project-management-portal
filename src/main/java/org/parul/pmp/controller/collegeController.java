package org.parul.pmp.controller;

import org.parul.pmp.dto.college;
import org.parul.pmp.repository.collegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/collegeregister")
public class collegeController {
    @Autowired
    private collegeRepository collegeRepository;
    @GetMapping
    public String registerCollege(Model model)
    {
        model.addAttribute("college",new college());
        return "college";
    }
    @PostMapping
    public String addCollegePage(@ModelAttribute("college")college college, Model model)
    {
        try
        {
            collegeRepository.saveAndFlush(college);
            model.addAttribute("msg","College Successfully Registered");
        }
        catch (Exception e)
        {
            model.addAttribute("msg","College not Registered");
        }

       return "college";
    }

}
