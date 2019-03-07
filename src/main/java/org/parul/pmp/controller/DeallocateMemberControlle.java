package org.parul.pmp.controller;

import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.dto.mapper.StudentMapper;
import org.parul.pmp.entity.GroupDetails;
import org.parul.pmp.entity.Student;
import org.parul.pmp.entity.User;
import org.parul.pmp.repository.GroupRepository;
import org.parul.pmp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/deallocatemember")
public class DeallocateMemberControlle {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;
    @GetMapping
    public String selectMember(Model model)
    {
        model.addAttribute("deallocate", new StudentDTO());
        return "deallocatemember";
    }

    @PostMapping
    private String deallocateMember(@RequestParam (value = "enrollment", required = false) Long enrollment ,Model model)
    {
        if (enrollment != null)
        {
            Student student = studentRepository.getOne(enrollment);
            GroupDetails group = student.getProjectGroup();

        }
        return "welcome";
    }
    /*@PostMapping
    @Transactional
    public String selectmember(@RequestParam(value = "enrollment") Long enrollment ,Model model)
    {
        Student student = studentRepository.findById(enrollment).get();
        return "welcome";
        student.setProjectGroup(null);
        GroupDetails group = student.getProjectGroup();
        group.getMembers().remove(student);
        studentRepository.saveAndFlush(student);
        groupRepository.saveAndFlush(group);
        return "deallocatemembernext";
    }*/

}
