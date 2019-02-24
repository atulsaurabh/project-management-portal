package org.parul.pmp.controller;

import org.parul.pmp.dto.*;
import org.parul.pmp.dto.mapper.DepartmentMapper;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.dto.mapper.StudentMapper;
import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.Project;
import org.parul.pmp.entity.Student;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.ProjectRepository;
import org.parul.pmp.repository.StudentRepository;
import org.parul.pmp.service.ProjectGroupService;
import org.parul.pmp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectGroupService projectGroupService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProjectService projectService;
    @GetMapping("/projectDetails")
    public String projectDetails(Model model)
    {
        model.addAttribute("projectDTO",new ProjectDTO());
        return "project";
    }
    @PostMapping("/projectDetails")
    public String addProjectDetails(@ModelAttribute("projectDTO")ProjectDTO projectDTO,Model model)
    {
        try
        {
            projectService.addProject(projectDTO);
            model.addAttribute("msg","Sucessful");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }
        return "project";
    }
    @GetMapping("/group")
    public String projectGroup(Model model)
    {
        List<Department> departments= departmentRepository.findAll();
        List<DepartmentDTO> dtos=departments.stream().map(DepartmentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("depts",dtos);
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = students.stream().map(StudentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("students",studentDTOS);
        List<Faculty> faculties = facultyRepository.findAll();
        List<FacultyDTO> facultyDTOS = faculties.stream().map(FacultyMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("faculties",facultyDTOS);
        model.addAttribute("groupDTO", new GroupDTO());
        return "projectGroup";
    }
    @PostMapping("/group")
    public String createGroup(@ModelAttribute("groupDTO")GroupDTO groupDTO,Model model)
    {
        try
        {
            projectGroupService.createGroup(groupDTO);
            model.addAttribute("msg", "Successful");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "Error");
        }
        return "projectGroup";
    }

}
