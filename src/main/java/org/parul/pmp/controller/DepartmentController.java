package org.parul.pmp.controller;

import org.parul.pmp.dto.CollegeDTO;
import org.parul.pmp.dto.DepartmentDTO;
import org.parul.pmp.dto.mapper.CollegeMapper;
import org.parul.pmp.dto.mapper.DepartmentMapper;
import org.parul.pmp.entity.College;
import org.parul.pmp.entity.Department;
import org.parul.pmp.repository.CollegeRepository;
import org.parul.pmp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.parul.pmp.repository.DepartmentRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CollegeRepository collegeRepository;



    @GetMapping
    public String getDepartment(Model model){
        List<College> colleges= collegeRepository.findAll();
        List<CollegeDTO> dtos=colleges.stream().map(CollegeMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("colleges",dtos);

        model.addAttribute("department",new DepartmentDTO());
        return "department";
    }

    @PostMapping
    public String addDepartment(@ModelAttribute("department") DepartmentDTO department, Model model)
    {
        try {

            departmentService.addDepartment(department);
            model.addAttribute("msg", "Department added Successfully!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("errmsg", "Error!");
        }
        return "collegeAdmin";
    }
}
