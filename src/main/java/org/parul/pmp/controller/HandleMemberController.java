package org.parul.pmp.controller;

import org.parul.pmp.dto.GroupDTO;
import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.dto.mapper.GroupMapper;
import org.parul.pmp.dto.mapper.StudentMapper;
import org.parul.pmp.entity.*;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.GroupRepository;
import org.parul.pmp.repository.StudentRepository;
import org.parul.pmp.service.Mailserviceforgroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.acl.Group;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/handlemember")
public class HandleMemberController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private Mailserviceforgroup mailService;
    private String enrollment;
    private Model model;


    @GetMapping
    public String selectMember(Model model)
    {
        model.addAttribute("deallocate", new StudentDTO());
        return "deallocatemember";
    }


    @PostMapping
    public String deallocateMember(@RequestParam(value = "enrollment") String enrollment ,Model model)
    {
        model.addAttribute("std",new StudentDTO());
        if (enrollment != null)
        {
            Student student=studentRepository.findByEnrollment(enrollment).get();
            GroupDetails group = student.getProjectGroup();
            model.addAttribute("student", student);
            model.addAttribute("group",group);
            return "removemember";
        }
        return "welcome";
    }
    @PostMapping("/removemember")
    @Transactional
    public String remove(@RequestParam("enrollment") String enrollment, Model model)
    {
        Student student = studentRepository.findByEnrollment(enrollment).get();
        GroupDetails group = student.getProjectGroup();
        model.addAttribute("student", student);
        model.addAttribute("group",group);
        model.addAttribute("std",new StudentDTO());
        if (group != null) {
            group.getMembers().remove(student);
            student.setGroupMember(false);
            student.setProjectGroup(null);
            studentRepository.saveAndFlush(student);
            groupRepository.saveAndFlush(group);
            return "welcome";
        }
        return "deallocatemember";
    }

    @GetMapping("/addmember")
    public String addmember(Model model,HttpSession session)
    {

        Long userid = (Long) session.getAttribute("userid");
        Faculty faculty = facultyRepository.findById(userid).get();
        Department dept = faculty.getDepartment();

        List<GroupDetails> groupDetails = groupRepository.findByDepartment(dept);
        List<GroupDTO> groupDTOS = groupDetails.stream().map(GroupMapper::toDTO).collect(Collectors.toList());
        groupDTOS.stream().map(GroupDTO::getGroupId).collect(Collectors.toList());
        model.addAttribute("groupList",groupDTOS);
        model.addAttribute("groups", new GroupDTO());

        List<Student> students = studentRepository.findByDepartment(dept);
        List<StudentDTO> studentDTOS = students.stream().map(StudentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("students",studentDTOS);
        model.addAttribute("student", new StudentDTO());
       /* GroupDetails grpid = student.getProjectGroup();
        model.addAttribute("student",student);
        model.addAttribute("group",grpid);*/
        return "addmemberbyhod";
    }
    @PostMapping("/addmember")
    public String addothormember(@RequestParam("enrollment") String enrollment, Model model)
    {
        //GroupDetails groupDetails = groupRepository.findByGroupId(groupId).get();
        Optional<Student> student = studentRepository.findByEnrollment(enrollment);
        Student std = student.get();
        model.addAttribute("std",std);
        model.addAttribute("student",student);
        //model.addAttribute("group",groupDetails);
        //groupDetails.setMembers(Collections.singleton(std));
        //groupRepository.saveAndFlush(groupDetails);
        if(student.isPresent())
        {
            return "addmemberbyhodnext";
        }
        else
        {
            model.addAttribute("msg","user not available");
        }
        String email = student.get().getEmail();
        model.addAttribute("mailId",email);
        String firstname = student.get().getFirstname();
        return "redirect:/grouprequestmail";
    }
    @GetMapping("/grouprequestmail")
    public String sendgrouprequest(@RequestParam(name = "email")String email,
                                   @RequestParam("enrollment")String enrollment ,
                                   @RequestParam("groupId") Long groupId,
                                   Model model,HttpSession session)
    {
        Student student= studentRepository.findByEnrollment(enrollment).get();

        GroupDetails groupid = groupRepository.findByGroupId(groupId).get();
        model.addAttribute("grp", groupid);
        String groupname = groupid.getGroupName();
        Long userid = (Long) session.getAttribute("userid");

        if(student.isGroupMember())
        {model.addAttribute("msg","alredy added");}
        else {
            MailDTO mailDTO = new MailDTO();
            mailDTO.setName("reshma");
            mailDTO.setTo(email);
            mailDTO.setSubject("Group Member Request");
            mailDTO.setGroup(groupname);
            //mailDTO.setCordinator(cordinatorEnroll);
            mailDTO.setLink("http://localhost:8080/groupjoininvitation?userid="+userid+"&groupid="+groupid);
            mailService.sendActivationMailWithCredential(mailDTO);
            model.addAttribute("emailID",email);}
        return "groupjoininvitation";

    }

}
