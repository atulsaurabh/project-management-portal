package org.parul.pmp.service;

import org.parul.pmp.dto.GroupDTO;
import org.parul.pmp.dto.mapper.GroupMapper;
import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.GroupDetails;
import org.parul.pmp.entity.Student;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.GroupRepository;
import org.parul.pmp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;


@Service
public class ProjectGroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public void createGroup(GroupDTO groupDTO,Student student)
    {
        GroupDetails grp = GroupMapper.toEntity(groupDTO);
        grp.getMembers().add(student);


        grp.setYear(LocalDate.now().getYear());
        Department dept=student.getDepartment();
       // Student student=studentRepository.findById(groupDTO.getStudentId()).get();
       // Faculty faculty=facultyRepository.findById(groupDTO.getFaculty_id()).get();
        Instant today = Instant.now();
        grp.setDateOfGroupCreation(today);

        GroupDetails savedGroup =groupRepository.saveAndFlush(grp);
        dept.getProjectGroup().add(savedGroup);
        savedGroup.setDepartment(dept);
        departmentRepository.saveAndFlush(dept);
        //faculty.getProjectGroup().add(savedGroup);
        //savedGroup.setMentor(faculty);
        //facultyRepository.saveAndFlush(faculty);
        student.setProjectGroup(savedGroup);
        savedGroup.setCordinator(student);
        student.setCordinator(true);
        student.setGroupMember(true);
        studentRepository.saveAndFlush(student);
    }


}
