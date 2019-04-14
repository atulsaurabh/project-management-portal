package org.parul.pmp.controller;

import org.parul.pmp.dto.DepartmentDTO;
import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.mapper.DepartmentMapper;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.Role;
import org.parul.pmp.exception.RoleNotAvailableException;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.service.FacultyService;
import org.parul.pmp.service.HodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/addHod")
public class HodController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private HodService hodService;
    @GetMapping
    public String addHod(Model model) {

        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> dtos = departments.stream().map(DepartmentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("depts", dtos);
        return "addHod";
    }

    @PostMapping
    public String addHod(@RequestParam("department") long department, Model model) {


        Department dept = departmentRepository.findById(department).get();
        Set<FacultyDTO> facultyDTOSet = dept.getFaculties().stream().map(FacultyMapper::toDTO).collect(Collectors.toSet());
        model.addAttribute("faculties", facultyDTOSet);
        return "addHodNext";
    }

    @PostMapping("/promote")
    @Transactional
    public String promoteToHOD(@RequestParam("facultycode") Long facultycode,Model model)
    {
        Faculty faculty=facultyRepository.findByFacultyCode(facultycode).get();
        Optional<Faculty> facultyHOD=faculty.getDepartment().getFaculties().stream().filter(faculty1 -> {
            return faculty1.isHod();
        }).findFirst();
        if (facultyHOD.isPresent())
        {
            Faculty previousHOD= facultyHOD.get();
            previousHOD.setHod(false);
            facultyRepository.saveAndFlush(previousHOD);
        }

        faculty.setHod(true);
        facultyRepository.saveAndFlush(faculty);

        return addHod(model);
    }
    @GetMapping("/hodHomePage")
    public String hodHomePage(Model model)
    {
        return "hodHomePage";
    }

}
