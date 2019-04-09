package org.parul.pmp.controller;

import org.parul.pmp.dto.*;
import org.parul.pmp.dto.mapper.StudentMapper;
import org.parul.pmp.entity.*;
import org.parul.pmp.exception.SessionExpiredException;
import org.parul.pmp.repository.*;
import org.parul.pmp.service.Mailserviceforgroup;
import org.parul.pmp.service.ProjectGroupService;
import org.parul.pmp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private Mailserviceforgroup mailService;

    @GetMapping
    public String projectGroup(Model model)
    {
       /* List<Department> departments= departmentRepository.findAll();
        List<DepartmentDTO> dtos=departments.stream().map(DepartmentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("depts",dtos);
        /*List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = students.stream().map(StudentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("students",studentDTOS);
        List<Faculty> faculties = facultyRepository.findAll();
        List<FacultyDTO> facultyDTOS = faculties.stream().map(FacultyMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("faculties",facultyDTOS);*/
        model.addAttribute("groupDTO", new GroupDTO());
        return "projectGroup";
    }
    @PostMapping
    public String createGroup(@ModelAttribute("groupDTO")GroupDTO groupDTO, Model model, HttpSession session)
    {
        long userid = (long)session.getAttribute("userid");
        Student student = studentRepository.findById(userid).get();

        int thisyear = LocalDate.now().getYear();
        Optional<GroupDetails> groupName = groupRepository.findByGroupNameAndYear(groupDTO.getGroupName(),thisyear);
        if(student.isGroupMember())
        {
            model.addAttribute("errmsg","you already added in another group so you can't create a group");
            return "projectGroup";
        }
        else {
            if(groupName.isPresent())
            {
                 model.addAttribute("errmsg","Group Name is already avilable");
                 return "projectGroup";
            }
            else {
                    if(student.getProjectGroup() != null)
                    {
                        model.addAttribute("errmsg","Already created a group");
                        return "projectGroup";
                    }
                 else
                    projectGroupService.createGroup(groupDTO,student);
                    model.addAttribute("msg","Project Group Created Successfully!");
                }
        }
        return "projectGroup";
    }
    /*@PostMapping("/promoteCordinator")
    @Transactional
    public String promoteCordinator(@RequestParam("enrollment") String enrollment,Model model)
    {
        Student student = studentRepository.findByEnrollment(enrollment).get();
        Optional<Student> studentCordinator = student.getDepartment().getStudents().stream().filter(student1 -> {return student1.isCordinator();}).findFirst();
        if (studentCordinator.isPresent())
        {
            Student previousCordinator = studentCordinator.get();
            previousCordinator.setCordinator(false);
            studentRepository.saveAndFlush(previousCordinator);
        }
        student.setCordinator(true);
        studentRepository.saveAndFlush(student);
        return projectGroup (model);
    }*/
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
        return "welcome";
    }
    @GetMapping("/addmember")
    public String addmember(Model model,HttpSession session)
    {
        Long userid = (Long) session.getAttribute("userid");
        Student student =studentRepository.findById(userid).get();
        Department dept = student.getDepartment();
        List<Student> students = studentRepository.findByDepartment(dept);
        List<StudentDTO> studentDTOS = students.stream().map(StudentMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("students",studentDTOS);
        GroupDetails grpid = student.getProjectGroup();
        model.addAttribute("student",student);
        model.addAttribute("group",grpid);
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
            return "messagetemplate";
        }
        //String email = student.get().getEmail();
        //model.addAttribute("mailId",email);
       //String firstname = student.get().getFirstname();
       // return "redirect:/grouprequestmail";
    }
    @GetMapping("/grouprequestmail")
    public String sendgrouprequest(@RequestParam(name = "email")String email,@RequestParam("enrollment")String enrollment ,Model model,HttpSession session) throws SessionExpiredException
    {
        Student student= studentRepository.findByEnrollment(enrollment).get();
        String studentname = student.getFirstname();
        long userid = student.getUserid();
        Long cordinator = (Long) session.getAttribute("userid");
        if (cordinator ==null)
            throw new SessionExpiredException();
        Student student1 =studentRepository.findById(cordinator).get();
        GroupDetails groupDetails = student1.getProjectGroup();
        long groupid = groupDetails.getGroupId();
        String groupname = groupDetails.getGroupName();
        String cordinatorEnroll = student1.getEnrollment();
        Set<Student> groupmembers= groupDetails.getMembers();
        long groupmembersize = groupmembers.size();
        if(groupmembersize>=4)
        {
            model.addAttribute("msg","can't add members bcz group has already 4 members");
            return "messagetemplate";
        }
        else
        {
            if(student.isGroupMember())
            {
                model.addAttribute("msg","alredy added");
                return "messagetemplate";
            }

            MailDTO mailDTO = new MailDTO();
            //mailDTO.setUserid(student.getUserid());
            mailDTO.setName(studentname);
            mailDTO.setTo(email);
            mailDTO.setSubject("Group Member Request");
            mailDTO.setGroup(groupname);
            mailDTO.setCordinator(cordinatorEnroll);
            mailDTO.setLink("http://localhost:8080/groupjoininvitation?userid="+userid+"&groupid="+groupid);
            mailService.sendActivationMailWithCredential(mailDTO);
            model.addAttribute("emailID",email);
            return "groupjoininvitation";
        }

    }

}
