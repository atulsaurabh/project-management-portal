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

    public void createGroup(GroupDTO groupDTO)
    {
        GroupDetails grp = GroupMapper.toEntity(groupDTO);
        //Department dept=departmentRepository.findById(groupDTO.getDepartment()).get();
       // Student student=studentRepository.findById(groupDTO.getStudentId()).get();
       // Faculty faculty=facultyRepository.findById(groupDTO.getFaculty_id()).get();
        Instant i = Instant.now();
        grp.setDateOfGroupCreation(i);

        GroupDetails savedGroup =groupRepository.saveAndFlush(grp);
        /*dept.getProjectGroup().add(savedGroup);
        savedGroup.setDepartment(dept);
        departmentRepository.saveAndFlush(dept);
        faculty.getProjectGroup().add(savedGroup);
        savedGroup.setMentor(faculty);
        facultyRepository.saveAndFlush(faculty);
        student.setProjectGroup(savedGroup);
        savedGroup.setCordinator(student);
        studentRepository.saveAndFlush(student);*/


    }


}
