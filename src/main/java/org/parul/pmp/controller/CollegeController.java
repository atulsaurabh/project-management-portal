package org.parul.pmp.controller;

import org.parul.pmp.dto.CollegeDTO;
import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.dto.mapper.UniversityMapper;
import org.parul.pmp.entity.University;
import org.parul.pmp.repository.UniversityRepository;
import org.parul.pmp.service.CollegeService;
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
    private CollegeService collegeService ;
    @Autowired
    private UniversityRepository universityRepository;
    @GetMapping
    public String addCollegePage(Model model)
    {

        List<University> universities=universityRepository.findAll();
        List<UniversityDTO> dtos=universities.stream().map(UniversityMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("univercities",dtos);
        model.addAttribute("college",new CollegeDTO());
        return "college";
    }
    @PostMapping
    public String addCollegePage(@ModelAttribute("college") CollegeDTO college, Model model)
    {
        try
        {
            collegeService.addCollege(college);
            model.addAttribute("msg","College Successfully Registered");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg","College not Registered");
        }

       return "welcome";
    }

}
