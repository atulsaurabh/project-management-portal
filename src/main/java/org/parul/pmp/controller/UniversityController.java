package org.parul.pmp.controller;
import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.dto.mapper.UniversityMapper;
import org.parul.pmp.entity.University;
import org.parul.pmp.repository.universityRepository;
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
    private universityRepository universityRepository;
    @GetMapping
    public String addUniversityPage(Model model)
    {
        model.addAttribute("university", new UniversityDTO() );
        return "university";
    }

   @PostMapping("/register")
    public String registerUniversity(@ModelAttribute("university") UniversityDTO university, Model model) {
        try {

            universityRepository.saveAndFlush(UniversityMapper.toEntity(university));
            model.addAttribute("msg", "Successful");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }
        return "university";
        }
    }


