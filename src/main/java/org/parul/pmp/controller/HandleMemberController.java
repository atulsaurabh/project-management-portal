package org.parul.pmp.controller;

import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.dto.mapper.StudentMapper;
import org.parul.pmp.entity.*;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.GroupRepository;
import org.parul.pmp.repository.StudentRepository;
import org.parul.pmp.service.Mailserviceforgroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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


    @GetMapping
    public String selectMember(Model model)
    {
        model.addAttribute("deallocate", new StudentDTO());
        return "deallocatemember";
    }

    @PostMapping
    private String deallocateMember(@RequestParam("enrollment") String enrollment ,Model model)
    {
        if (enrollment != null) {

            Student student=studentRepository.findByEnrollment(enrollment).get();
            GroupDetails group = student.getProjectGroup();
            model.addAttribute("student", student);
            model.addAttribute("group",group);
        }
        return "removemember";
    }
    @PostMapping("/removemember")
    //@Transactional
    public String remove(@RequestParam("enrollment") String enrollment, Model model)
    {
        Student student = studentRepository.findByEnrollment(enrollment).get();
        GroupDetails group = student.getProjectGroup();

        if (group != null) {
            group.getMembers().remove(student);
            student.setGroupMember(false);
            student.setProjectGroup(null);
            studentRepository.saveAndFlush(student);
            groupRepository.saveAndFlush(group);
            return "welcome";
        }
        return "deallpcatemember";
    }

    @GetMapping("/addmember")
    public String addmember(Model model,HttpSession session)
    {
        Long userid = (Long) session.getAttribute("userid");
        Faculty faculty = facultyRepository.findById(userid).get();
        Department dept = faculty.getDepartment();
        List<Student> students = studentRepository.findByDepartment(dept);
        List<StudentDTO> studentDTOS = students.stream().map(StudentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("students",studentDTOS);
       /* GroupDetails grpid = student.getProjectGroup();
        model.addAttribute("student",student);
        model.addAttribute("group",grpid);*/
        return "addmember";
    }
    @PostMapping("/addmember")
    public String addothormember(@RequestParam("enrollment") String enrollment,Model model)
    {
        Optional<Student> student = studentRepository.findByEnrollment(enrollment);
        model.addAttribute("student",student.get());
        if(student.isPresent())
        {
            return "addmembernext";
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
    public String sendgrouprequest(@RequestParam(name = "email")String email,@RequestParam("enrollment")String enrollment ,Model model,HttpSession session)
    {
        Student student= studentRepository.findByEnrollment(enrollment).get();
        long userid = student.getUserid();
        Long cordinator = (Long) session.getAttribute("userid");
        Student student1 =studentRepository.findById(cordinator).get();
        long groupid = student1.getProjectGroup().getGroupId();
        String groupname = student1.getProjectGroup().getGroupName();
        String cordinatorEnroll = student1.getProjectGroup().getCordinator().getEnrollment();
        if(student.isGroupMember())
        {model.addAttribute("msg","alredy added");}
        else {
            MailDTO mailDTO = new MailDTO();
            //mailDTO.setUserid(student.getUserid());
            mailDTO.setName("reshma");
            mailDTO.setTo(email);
            mailDTO.setSubject("Group Member Request");
            mailDTO.setGroup(groupname);
            mailDTO.setCordinator(cordinatorEnroll);
            mailDTO.setLink("http://localhost:8080/groupjoininvitation?userid="+userid+"&groupid="+groupid);
            mailService.sendActivationMailWithCredential(mailDTO);
            model.addAttribute("emailID",email);}
        return "groupjoininvitation";

    }

}
