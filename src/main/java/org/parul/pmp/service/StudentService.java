package org.parul.pmp.service;

import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.dto.mapper.StudentMapper;
import org.parul.pmp.entity.*;
import org.parul.pmp.entity.enumeration.Roles;
import org.parul.pmp.exception.RoleNotAvailableException;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.repository.RoleRepository;
import org.parul.pmp.repository.StudentRepository;
import org.parul.pmp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public void addStudent(StudentDTO studentDTO) throws RoleNotAvailableException
    {
        Student student = StudentMapper.toEntity(studentDTO);
        Department dept=departmentRepository.findById(studentDTO.getDepartment_id()).get();
        LocalDateTime localDateTime = LocalDateTime.now();
        student.setDateOfModification(localDateTime);
        student.setDateOfRegistration(localDateTime);

       // User user = StudentMapper.toUserEntity(studentDTO);
        //User storedUser = userRepository.saveAndFlush(user);
        Student savedstudent = studentRepository.saveAndFlush(student);
        Credential credential = StudentMapper.toCredentialEntity(studentDTO);

        Optional<Role> optionalRole=roleRepository.findByName(Roles.ROLE_STUDENT.name());
        Role role = optionalRole.orElseThrow(()-> new RoleNotAvailableException());
        credential.getRoles().add(role);
        role.getCredential().add(credential);
        credential.setUser(savedstudent);
        savedstudent.setCredential(credential);
        Student savedStudent=studentRepository.saveAndFlush(student);
        dept.getStudents().add(savedStudent);
        savedStudent.setDepartment(dept);
        departmentRepository.saveAndFlush(dept);
    }
}
