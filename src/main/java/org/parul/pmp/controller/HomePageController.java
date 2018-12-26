package org.parul.pmp.controller;


import org.parul.pmp.dto.registerMember;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping
    public String homepage(Model model)
    {
        model.addAttribute("registerMember",new registerMember());
        return "registerMember";
    }

}
