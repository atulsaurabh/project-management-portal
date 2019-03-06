package org.parul.pmp.service;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.entity.*;
import org.parul.pmp.entity.enumeration.Roles;
import org.parul.pmp.exception.RoleNotAvailableException;
import org.parul.pmp.repository.DepartmentRepository;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.RoleRepository;
import org.parul.pmp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void addFaculty(FacultyDTO facultyDTO) throws RoleNotAvailableException
    {
        Faculty faculty = FacultyMapper.toEntity(facultyDTO);
        Department d=departmentRepository.findById(facultyDTO.getDepartment_id()).get();
        LocalDateTime localDateTime = LocalDateTime.now();
        faculty.setDateOfModification(localDateTime);
        faculty.setDateOfRegistration(localDateTime);
        faculty.setCollege(d.getCollege());
        faculty.setUniversity(d.getCollege().getUniversity());
        Faculty savedFaculty = facultyRepository.saveAndFlush(faculty);

        Credential credential= FacultyMapper.toCredentialEntity(facultyDTO);

        Optional<Role> optionalRole=roleRepository.findByName(Roles.ROLE_FACULTY.name());
        Role role = optionalRole.orElseThrow(()-> new RoleNotAvailableException());
        credential.getRoles().add(role);
        role.getCredential().add(credential);
        credential.setUser(savedFaculty);
        savedFaculty.setCredential(credential);
       // faculty.setUserfaculty(storedUser);
       // storedUser.setFaculty(faculty);
        Faculty finalSavedFaculty=facultyRepository.saveAndFlush(faculty);
        d.getFaculties().add(finalSavedFaculty);
        savedFaculty.setDepartment(d);
        departmentRepository.saveAndFlush(d);
    }

    public void promoteToHOD(FacultyDTO facultyDTO) throws RoleNotAvailableException {
        Faculty faculty = FacultyMapper.toEntity(facultyDTO);
        Faculty hod=facultyRepository.findByFacultyCode(facultyDTO.getFacultyCode()).get();
        //Faculty savedFaculty=facultyRepository.saveAndFlush(faculty);
        User user = FacultyMapper.toUserEntity(facultyDTO);
        User storedUser = userRepository.saveAndFlush(user);
        Credential credential = FacultyMapper.toCredentialEntity(facultyDTO);

        Optional<Role> optionalRole=roleRepository.findByName(Roles.ROLE_HOD.name());
        Role role = optionalRole.orElseThrow(()-> new RoleNotAvailableException());
        credential.getRoles().add(role);
        role.getCredential().add(credential);
        credential.setUser(storedUser);
        storedUser.setCredential(credential);

        hod.setHod(true);
    }
//
//    public void departmentViseFaculty(FacultyDTO facultyDTO)
//    {
//        Faculty hod=facultyRepository.findByDepartment(facultyDTO.getFacultyCode());
//        Faculty faculty=facultyRepository.findById(facultyDTO.getFacultyCode()).get();
//    }
}
