package org.parul.pmp.controller;

import org.parul.pmp.dto.GroupDTO;
import org.parul.pmp.dto.MailDTO;
import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.dto.mapper.GroupMapper;
import org.parul.pmp.dto.mapper.StudentMapper;
import org.parul.pmp.entity.GroupDetails;
import org.parul.pmp.entity.Student;
import org.parul.pmp.entity.User;
import org.parul.pmp.entity.Year;
import org.parul.pmp.repository.GroupRepository;
import org.parul.pmp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/contect")
public class ContectController {
    @Value("spring.mail.username")
    private String email;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @GetMapping
    public String year(Model model)
    {
        /*List<GroupDetails> groups = groupRepository.findAll();
        List<GroupDTO> groupDTOList = groups.stream().map(GroupMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("groups",groupDTOList);*/
        return "contect";
    }
    @GetMapping("/selectgroup")
    public String groupPage(HttpSession session, @RequestParam("year")int year,Model model)
    {
        //long userid = (Long) session.getAttribute("userid");
        List<GroupDetails> groups = groupRepository.findByYear(year);
        List<GroupDTO> groupDTOS = groups.stream().map(GroupMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("groups",groupDTOS);
        //User user = userRepository.findById(userid).get();
        model.addAttribute("groups",groups);
       // model.addAttribute("msg","Group selection done");
        return "contectNext";

    }
    @PostMapping("/groupmember")
    public String contectTo(@RequestParam("groupid") long groupid,@RequestParam("subject") String subject ,@RequestParam("message") String message,Model model){
        GroupDetails group= groupRepository.findById(groupid).get();
        Set<Student> students = group.getMembers();
        for (Student student:students
             ) {
            MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
                mimeMessageHelper.setFrom(email);
                mimeMessageHelper.setTo(student.getEmail());
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(message);
            };
            javaMailSender.send(mimeMessagePreparator);
        }
        //model.addAttribute("students",students);
        //return "groupdetails";
        model.addAttribute("msg","suceesfully send email");
        return "result";

    }
    /*@PostMapping("sendemail")
    public String sendemail(@RequestParam("emails")String[] emails,@RequestParam("message")String message,Model model)
    {
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(email);
            mimeMessageHelper.setTo(emails);
            mimeMessageHelper.setSubject("Project Instuction");
            mimeMessageHelper.setText(message);
        };
        javaMailSender.send(mimeMessagePreparator);
        model.addAttribute("msg","suceesfully send email");
        return "result";*/

}
