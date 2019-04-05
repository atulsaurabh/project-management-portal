package org.parul.pmp.controller;

import org.parul.pmp.dto.DocTypeDTO;
import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.mapper.DocTypeMapper;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.DocType;
import org.parul.pmp.entity.Documents;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.repository.DocTypeRepository;
import org.parul.pmp.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/projectcordinator")
public class ProjectCoordinatorController {

    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private DocTypeRepository docTypeRepository;

    @GetMapping
    public String addCodinator(HttpSession session, Model model) {
        Long userid = (Long) session.getAttribute("userid");
        Faculty faculty = facultyRepository.findById(userid).get();
        Department dept = faculty.getDepartment();
        System.out.println(dept);
        //Set<FacultyDTO> facultyDTOSet = dept.getFaculties().stream().map(FacultyMapper::toDTO).collect(Collectors.toSet());
        List<Faculty> faculties = facultyRepository.findByDepartment(dept);
        List<FacultyDTO> facultyDTOSet = faculties.stream().map(FacultyMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("faculties", facultyDTOSet);
        model.addAttribute("faculty", faculty);
        return "projectcoordinator";
    }

    @PostMapping
    public String addCodinator(@RequestParam("facultycode") Long facultycode, Model model) {
        Faculty faculty = facultyRepository.findByFacultyCode(facultycode).get();
        Optional<Faculty> facultyCodinator = faculty.getDepartment().getFaculties().stream().filter(faculty1 -> {
            return faculty1.isProjectCoodinator();
        }).findFirst();
        if (facultyCodinator.isPresent()) {
            Faculty previousCoodinator = facultyCodinator.get();
            previousCoodinator.setProjectCoodinator(false);
            facultyRepository.saveAndFlush(previousCoodinator);
        }

        faculty.setProjectCoodinator(true);
        facultyRepository.saveAndFlush(faculty);
        return "welcome";
    }

    @GetMapping("/configureDocs")
    public String configureDocs(Model model)
    {
        List<DocType> docTypes = docTypeRepository.findAll();
        List<DocTypeDTO> docTypeDTOS = docTypes.stream().map(DocTypeMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("docTypes",new DocTypeDTO());
        model.addAttribute("docTypeDTOS",docTypeDTOS);
        return "configuredocumentlist";
    }

    @PostMapping("/configureDocs")
    public String configureDocs(@RequestParam("doctypeid") long doctypeid ,Model model)
    {
        return "";
    }
}
