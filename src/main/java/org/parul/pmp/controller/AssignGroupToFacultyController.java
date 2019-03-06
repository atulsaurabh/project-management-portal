package org.parul.pmp.controller;

import org.parul.pmp.dto.FacultyAndGroupDTO;
import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.GroupDTO;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.dto.mapper.GroupMapper;
import org.parul.pmp.entity.*;
import org.parul.pmp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/assigngrptofact")
public class AssignGroupToFacultyController {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public String assignGrpToFact(Model model, HttpSession session)
    {
        Long userid = (Long) session.getAttribute("userid");
        Faculty hod = facultyRepository.findById(userid).get();
        Department department = hod.getDepartment();
        List<Faculty> faculties= facultyRepository.findByDepartment(department);
        List<FacultyDTO> dtos= faculties.stream().map(FacultyMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("facts", dtos);
        model.addAttribute("facandgrp",new FacultyAndGroupDTO());
        Set<GroupDTO> groupDTOS = department.getProjectGroup().stream().filter(groupDetails -> groupDetails.getMentor() == null).map(GroupMapper::toDTO).collect(Collectors.toSet());
        model.addAttribute("groups",groupDTOS);
        return "assigngrptofact";
    }
    @PostMapping
    public String assignGrpToFactNext(Model model, HttpSession session)
    {
        Long userid = (Long) session.getAttribute("userid");
        Faculty hod = facultyRepository.findById(userid).get();
        Department department1 = hod.getDepartment();
        Set<GroupDTO> groupDTOS = department1.getProjectGroup().stream().map(GroupMapper::toDTO).collect(Collectors.toSet());
        model.addAttribute("groups", groupDTOS);
        return "assigngrptofactnext";
    }

    @PostMapping("showgrp")
    @Transactional
    public String showGrpAndSelect(@ModelAttribute("facandgrp")FacultyAndGroupDTO facandgrp,Model model)
    {
        Faculty faculty=facultyRepository.findByFacultyCode(facandgrp.getFacultyId()).get();
        facandgrp.getGroupid().forEach(groupId -> {
            GroupDetails groupDetails = groupRepository.findById(groupId).get();
            groupDetails.setMentor(faculty);
            faculty.getProjectGroup().add(groupDetails);
            facultyRepository.saveAndFlush(faculty);
        });

        return "redirect:/assigngrptofact";

    }
}

