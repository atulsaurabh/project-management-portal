package org.parul.pmp.controller;

import org.parul.pmp.dto.*;
import org.parul.pmp.dto.mapper.*;
import org.parul.pmp.entity.*;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.GroupRepository;
import org.parul.pmp.service.FacultyProfileService;
import org.parul.pmp.service.FacultyService;
import org.parul.pmp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private FacultyProfileService facultyProfileService;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private MailService mailService;
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public String addFaculty(Model model) {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> dtos = departments.stream().map(DepartmentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("depts", dtos);
        model.addAttribute("faculty", new FacultyDTO());
        return "faculty";
    }

    @PostMapping
    public String registerFaculty(@ModelAttribute("faculty") FacultyDTO faculty, Model model) {
        try {
            facultyService.addFaculty(faculty);
            //model.addAttribute("msg", "Successful");
            MailDTO mailDTO = new MailDTO();
            mailDTO.setName(faculty.getFacultyFirstname());
            mailDTO.setPassword(faculty.getPassword());
            mailDTO.setTo(faculty.getEmail());
            mailDTO.setSubject("Account Activation");
            mailDTO.setLink("http://localhost:8080/activate");
            mailService.sendActivationMailWithCredential(mailDTO);
            model.addAttribute("emailId", faculty.getEmail());
            return "faculty";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errmsg", "Error");
        }
        return "collegeAdmin";
    }

    @GetMapping("/profile")
    public String addFacultyProfile(Model model) {
        model.addAttribute("facultyProfileDTO", new FacultyProfileDTO());
        return "facultyProfile";
    }

    @PostMapping("/profile")
    public String profileOfFaculty(@ModelAttribute("facultyProfileDTO") FacultyProfileDTO facultyProfileDTO, Model model) {
        try {

            facultyProfileService.addFacultyProfile(facultyProfileDTO);
            model.addAttribute("msg", "Successful");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }
        return "Welcome";
    }

    @GetMapping("/assignedgroups")
    public String groups(Model model, HttpSession session)
    {
        Long userid = (Long) session.getAttribute("userid");
        Faculty faculty = facultyRepository.findById(userid).get();
        GroupDetails gpd = new GroupDetails();
        Instant year = gpd.getDateOfGroupCreation();
        List<GroupDetails> groupDetails = groupRepository.findByMentor(faculty);
        model.addAttribute("grp",new GroupDTO());
        model.addAttribute("groups",groupDetails);
        return "assignedgroups";
    }

    @PostMapping("/assignedgroups")
    public String groups(@RequestParam("groupId") Long groupId ,Model model)
    {
        GroupDetails groupDetails = groupRepository.findByGroupId(groupId).get();
        Set<Student> members = groupDetails.getMembers();
        model.addAttribute("grp",new GroupDTO());
        model.addAttribute("grpdetils",groupDetails);
        model.addAttribute("members",members);


        return "detailsofgrp";

    }



}


