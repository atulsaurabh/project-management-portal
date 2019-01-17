package org.parul.pmp.controller;

import org.parul.pmp.dto.CollegeDTO;
import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.dto.mapper.UniversityMapper;
import org.parul.pmp.entity.College;
import org.parul.pmp.entity.University;
import org.parul.pmp.repository.CollegeRepository;
import org.parul.pmp.repository.UniversityRepository;
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
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @GetMapping

    public String addCollege(Model model)
    {
        List<University> universities= universityRepository.findAll();
        List<UniversityDTO> dtos= universities.stream().map(UniversityMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("uni", dtos);
        model.addAttribute("college",new CollegeDTO());
        return "college";
    }
    public String registerCollege(Model model)
    {
        model.addAttribute("college",new College());
        return "college";
    }
    @PostMapping
    public String addCollegePage(@ModelAttribute("college") College college, Model model)
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
