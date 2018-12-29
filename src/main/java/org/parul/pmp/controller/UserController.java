package org.parul.pmp.controller;

import org.parul.pmp.dto.UserDTO;
import org.parul.pmp.mapper.UserDtoToEntityMapper;
import org.parul.pmp.repository.PmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserController {
    @Autowired
    private PmpRepository pmpRepository;

    @GetMapping
    public String addMember(Model model)
    {
        model.addAttribute("userDTO",new UserDTO());
        return "User";
    }

    @PostMapping
    public String pmpMember(@ModelAttribute("userDTO") UserDTO userDTO, Model model)
    {
        UserDtoToEntityMapper mapper=new UserDtoToEntityMapper();
        pmpRepository.saveAndFlush(mapper.toEnity(userDTO));
        model.addAttribute("msg","Registartion Done Successfully");
        return "Welcome";
    }
}
