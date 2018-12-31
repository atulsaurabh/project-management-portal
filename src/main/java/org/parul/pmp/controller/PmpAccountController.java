package org.parul.pmp.controller;

import org.parul.pmp.dto.ProfileDTO;
import org.parul.pmp.dto.UserDTO;
import org.parul.pmp.mapper.ProfileDtoToEntityMapper;
import org.parul.pmp.mapper.UserDtoToEntityMapper;
import org.parul.pmp.repository.PmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class PmpAccountController {
    @Autowired
    private PmpRepository pmpRepository;

    @GetMapping("/member")
    public String addMember(Model model)
    {
        model.addAttribute("userDTO",new UserDTO());
        return "User";
    }

    @GetMapping("/profile")
    public String addProfile(Model model){
        model.addAttribute("profileDTO",new ProfileDTO());
        return "StudentProfile";
    }

    @PostMapping("/member")
    public String pmpMember(@ModelAttribute("userDTO") UserDTO userDTO,Model model)
    {
        UserDtoToEntityMapper mapper=new UserDtoToEntityMapper();
        pmpRepository.saveAndFlush(mapper.toEnity(userDTO));
        model.addAttribute("msg","Registartion Done Successfully");
        return "Welcome";
    }

    @PostMapping("/profile")
    public String pmpProfile(@ModelAttribute("profileDTO") ProfileDTO profileDTO,Model model)
    {
        ProfileDtoToEntityMapper mapper=new ProfileDtoToEntityMapper();
        pmpRepository.saveAndFlush(mapper.toEnity(profileDTO));
        model.addAttribute("msg","Profile added Successfully");
        return "Welcome";
    }
}
