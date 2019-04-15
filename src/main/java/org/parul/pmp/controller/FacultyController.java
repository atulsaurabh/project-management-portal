package org.parul.pmp.controller;

import org.parul.pmp.dto.*;
import org.parul.pmp.dto.mapper.*;
import org.parul.pmp.entity.*;
import org.parul.pmp.repository.*;
import org.parul.pmp.service.FacultyProfileService;
import org.parul.pmp.service.FacultyService;
import org.parul.pmp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UrlPathHelper;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.util.StreamUtils.BUFFER_SIZE;

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
    @Autowired
    private UploadDocRepository uploadDocRepository;
    @Autowired
    private DocTypeRepository docTypeRepository;

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
        return "faculty";
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
    public String groups(@RequestParam("groupId") Long groupId ,Model model) throws URISyntaxException {
        //Optional<GroupDetails> groupDetailsOptional = groupRepository.findByGroupId(groupId).get();
        GroupDetails groupDetails = groupRepository.findByGroupId(groupId).get();
        Set<Student> members = groupDetails.getMembers();
        model.addAttribute("grp",new GroupDTO());
        model.addAttribute("grpdetils",groupDetails);
        model.addAttribute("members",members);



        Set<UplodedDocuments> documents = groupDetails.getUplodedDocuments();
        documents.stream().map(UplodedDocuments::getDescription).collect(Collectors.toList());
        documents.stream().map(UplodedDocuments::getGroupDetails).collect(Collectors.toList());
        documents.stream().map(UplodedDocuments::getUploaddocid).collect(Collectors.toList());
        documents.stream().map(UplodedDocuments::getDescription).collect(Collectors.toList());
        documents.stream().map(UplodedDocuments::getUploadedby).collect(Collectors.toList());
        documents.stream().map(UplodedDocuments::getData).collect(Collectors.toList());
        documents.stream().map(UplodedDocuments::isApproved).collect(Collectors.toList());
        documents.stream().map(UplodedDocuments::getDocurl).collect(Collectors.toList());

        try {
            URL url = new URL("file:/C:/Users/shubh/report1.pdf");
            model.addAttribute("url",url);
        } catch (MalformedURLException e) {


        }


//        File file=new File(url.toURI());
//        String str = file.getName();
//        model.addAttribute("file", str);

        model.addAttribute("documents",documents);
        //model.addAttribute("docs",new DocumentDTO());
        //model.addAttribute("doctypes",new DocTypeDTO());

        return "detailsofgrp";
    }

    @PostMapping("grpdocs")
    public String grpdocs(@RequestParam("groupId") Long groupId ,@RequestParam("docId") long docId , Model model, HttpSession session)
    {
        GroupDetails grpId = groupRepository.findByGroupId(groupId).get();
        UplodedDocuments uplodedDocuments = uploadDocRepository.findById(docId).get();

        uplodedDocuments.setGroupDetails(grpId);
        uplodedDocuments.setApproved(true);
        groupRepository.saveAndFlush(grpId);
        uploadDocRepository.saveAndFlush(uplodedDocuments);
        return "welcome";
    }



}


