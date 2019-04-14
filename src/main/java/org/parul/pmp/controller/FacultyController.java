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

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
    public String groups(@RequestParam("groupId") Long groupId ,Model model)
    {
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
        /*documents.stream().map(UplodedDocuments::getDocurl).filter(url ->
        {
            String str = String.valueOf(url.toString().lastIndexOf('/')+1);
            return str;
        }).collect(Collectors.toList());*/
        model.addAttribute("documents",documents);
        //model.addAttribute("docs",new DocumentDTO());
        //model.addAttribute("doctypes",new DocTypeDTO());

        return "detailsofgrp";
    }

  /*  @PostMapping("/download")
    public static void downloadFile(String fileURL, String saveDir)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }

            //System.out.println("Content-Type = " + contentType);
            //System.out.println("Content-Disposition = " + disposition);
            //System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }*/


    @PostMapping("grpdocs")
    public String grpdocs(@RequestParam("groupId") Long groupId ,@RequestParam("docId") long docId , Model model, HttpSession session)
    {
        GroupDetails grpId = groupRepository.findByGroupId(groupId).get();
        UplodedDocuments uplodedDocuments = uploadDocRepository.findById(docId).get();
 /*       Stream<UplodedDocuments> uplodedDoc = grpId.getUplodedDocuments().stream().filter(uplodedDocuments1 ->
        {
            status.replace("NA","Approve");
            return uplodedDocuments1.isApproved();

        } );
        model.addAttribute("uplodeDoc",uplodedDoc);*/
        uplodedDocuments.setGroupDetails(grpId);
        uplodedDocuments.setApproved(true);
        groupRepository.saveAndFlush(grpId);
        uploadDocRepository.saveAndFlush(uplodedDocuments);
        return "welcome";
    }



}


