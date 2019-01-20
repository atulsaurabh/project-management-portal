package org.parul.pmp.service;

import org.parul.pmp.dto.CollegeDTO;
import org.parul.pmp.dto.mapper.CollegeMapper;
import org.parul.pmp.entity.*;
import org.parul.pmp.entity.enumeration.Roles;
import org.parul.pmp.exception.RoleNotAvailableException;
import org.parul.pmp.repository.CollegeRepository;
import org.parul.pmp.repository.RoleRepository;
import org.parul.pmp.repository.UniversityRepository;
import org.parul.pmp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void addCollege(CollegeDTO collegeDTO) throws RoleNotAvailableException
    {
        College college = CollegeMapper.toEntity(collegeDTO);
        University u=universityRepository.findById(collegeDTO.getUniversity_id()).get();

        LocalDateTime localDateTime = LocalDateTime.now();
        college.setDateOfModification(localDateTime);
        college.setDateOfRegistration(localDateTime);

        User user = CollegeMapper.toUserEntity(collegeDTO);
        User storedUser = userRepository.saveAndFlush(user);
        Credential credential1 = CollegeMapper.toCredentialEntity(collegeDTO);

        Optional<Role> optionalRole=roleRepository.findByName(Roles.ROLE_COLLEGE_ADMIN.name());
        Role role = optionalRole.orElseThrow(()-> new RoleNotAvailableException());
        credential1.getRoles().add(role);
        role.getCredential().add(credential1);
        credential1.setUser(storedUser);
        storedUser.setCredential(credential1);
        college.setCollegeAdmin(storedUser);
        storedUser.setCollege(college);
        College savedCollege = collegeRepository.saveAndFlush(college);
        u.getColleges().add(savedCollege);
        savedCollege.setUniversity(u);
        universityRepository.saveAndFlush(u);
    }

}
