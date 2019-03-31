package org.parul.pmp.controller;
import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public String addUniversityPage(Model model)
    {
        model.addAttribute("university", new UniversityDTO() );
        return "university";
    }


   @PostMapping()
    public String registerUniversity(@ModelAttribute("university") UniversityDTO university, Model model) {
        try {

            universityService.addUniversity(university);
            model.addAttribute("msg", "Successful");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }
        return "welcome";
        }
    }


