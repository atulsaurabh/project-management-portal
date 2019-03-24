package org.parul.pmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/collegeAdmin")
public class CollegeAdminController {
    @GetMapping
    public String collegeAdminPage()
    {
        return "collegeAdmin";
    }
}
