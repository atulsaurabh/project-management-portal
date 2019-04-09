package org.parul.pmp.controller;

import org.parul.pmp.dto.StudentProfileDTO;
import org.parul.pmp.dto.mapper.ProfileDtoToEntityMapper;
import org.parul.pmp.repository.PmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private PmpRepository pmpRepository;

    @GetMapping
    public String addProfile(Model model){
        model.addAttribute("profileDTO",new StudentProfileDTO());
        return "StudentProfile";
    }

    @PostMapping
    public String pmpProfile(@ModelAttribute("profileDTO") StudentProfileDTO profileDTO, Model model)
    {
        ProfileDtoToEntityMapper mapper=new ProfileDtoToEntityMapper();
        pmpRepository.saveAndFlush(mapper.toEnity(profileDTO));
        model.addAttribute("msg","Profile added Successfully");
        return "Welcome";
    }
}
