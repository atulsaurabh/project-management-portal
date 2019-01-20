package org.parul.pmp.service;

import org.parul.pmp.dto.DepartmentDTO;
import org.parul.pmp.dto.mapper.DepartmentMapper;
import org.parul.pmp.entity.College;
import org.parul.pmp.entity.Department;
import org.parul.pmp.exception.RoleNotAvailableException;
import org.parul.pmp.repository.CollegeRepository;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.repository.RoleRepository;
import org.parul.pmp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CollegeRepository collegeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public void addDepartment(DepartmentDTO departmentDTO) throws RoleNotAvailableException
    {
        Department department = DepartmentMapper.toEntity(departmentDTO);
        College clg = collegeRepository.findById(departmentDTO.getCollege_id()).get();
        LocalDateTime localDateTime = LocalDateTime.now();
        department.setDateOfModification(localDateTime);
        department.setDateOfRegistration(localDateTime);


        Department savedDepartment=departmentRepository.saveAndFlush(department);
        clg.getDepartments().add(savedDepartment);
        savedDepartment.setCollege(clg);
        collegeRepository.saveAndFlush(clg);
    }
}
