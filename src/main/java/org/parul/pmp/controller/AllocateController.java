package org.parul.pmp.controller;

import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.dto.mapper.StudentMapper;
import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.GroupDetails;
import org.parul.pmp.entity.Student;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/allocatemember")
public class AllocateController {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping
    public String addmember(Model model, HttpSession session)
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
    @PostMapping
    public String addothormember(@RequestParam("enrollment") String enrollment, Model model)
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
        return "redirect:/addmember";
    }

}
