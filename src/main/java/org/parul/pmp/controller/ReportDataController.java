package org.parul.pmp.controller;

import org.parul.pmp.dto.GroupDTO;
import org.parul.pmp.dto.ReportDto;
import org.parul.pmp.dto.mapper.GroupMapper;
import org.parul.pmp.entity.GroupDetails;
import org.parul.pmp.entity.Student;
import org.parul.pmp.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("reportdata")
public class ReportDataController {
    @Autowired
    private GroupRepository groupRepository;
    @GetMapping
    public String collectdata(Model model){
        List<GroupDetails> groupDetailsList =groupRepository.findAll();
        List<GroupDTO> groupDTOS = groupDetailsList.stream().map(GroupMapper::toDTO).collect(Collectors.toList());
        for (GroupDTO group:groupDTOS
             ) {
            long groupid = group.getGroupId();
            GroupDetails group1 = groupRepository.findById(groupid).get();
            Set<Student> students = group1.getMembers();
            model.addAttribute("group",group1);
            for (Student student:students
                 ) {
                String enroll = student.getEnrollment();
                return "redirect:/http://localhost:8080/report/stu_list?enrollment="+enroll;
            }
            return "redirect:/http://localhost:8080/report/stu_list?groupid="+groupid;
            }
        model.addAttribute("msg","report done");
       return "result";
    }
}
