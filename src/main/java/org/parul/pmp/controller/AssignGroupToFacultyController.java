package org.parul.pmp.controller;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/assigngrptofact")
public class AssignGroupToFacultyController {
    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping
    public String assignGrpToFact(Model model)
    {
        List<Faculty> faculties = facultyRepository.findAll();
        List<FacultyDTO> dtos= faculties.stream().map(FacultyMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("facts", dtos);
        return "assigngrptofact";
    }
}

