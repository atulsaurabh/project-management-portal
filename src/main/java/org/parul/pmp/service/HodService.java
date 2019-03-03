package org.parul.pmp.service;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.Role;
import org.parul.pmp.entity.User;
import org.parul.pmp.entity.enumeration.Roles;
import org.parul.pmp.exception.RoleNotAvailableException;
import org.parul.pmp.repository.FacultyRepository;
import org.parul.pmp.repository.RoleRepository;
import org.parul.pmp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HodService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void promoteToHOD(FacultyDTO facultyDTO) throws RoleNotAvailableException
    {
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
