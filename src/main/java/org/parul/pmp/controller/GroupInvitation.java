package org.parul.pmp.controller;

import org.parul.pmp.entity.GroupDetails;
import org.parul.pmp.entity.Student;
import org.parul.pmp.repository.GroupRepository;
import org.parul.pmp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/groupjoininvitation")
public class GroupInvitation {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;
    @GetMapping
    public String addmembertogroup(@RequestParam(name= "userid")long userid,@RequestParam(name="groupid") long groupid ,Model model)
    {
        Student student = studentRepository.findById(userid).get();
        student.setGroupMember(true);
        GroupDetails group = groupRepository.findById(groupid).get();
        student.setProjectGroup(group);
        group.getMembers().add(student);
        studentRepository.saveAndFlush(student);
        groupRepository.saveAndFlush(group);
        return "succesfull";
    }

}
