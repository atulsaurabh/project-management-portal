package org.parul.pmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/universityAdmin")
public class UniversityAdminController {
    @GetMapping
    public String universityAdminPage()
    {
        return "universityAdmin";
    }
}
