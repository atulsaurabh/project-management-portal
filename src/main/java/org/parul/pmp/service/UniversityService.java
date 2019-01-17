package org.parul.pmp.service;

import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.dto.mapper.UniversityMapper;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.Role;
import org.parul.pmp.entity.University;
import org.parul.pmp.entity.User;
import org.parul.pmp.entity.enumeration.Roles;
import org.parul.pmp.exception.RoleNotAvailableException;
import org.parul.pmp.repository.RoleRepository;
import org.parul.pmp.repository.UniversityRepository;
import org.parul.pmp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void addUniversity(UniversityDTO universityDTO) throws RoleNotAvailableException
    {
        University university = UniversityMapper.toEntity(universityDTO);
        LocalDateTime localDateTime = LocalDateTime.now();
        university.setDateOfModification(localDateTime);
        university.setDateOfRegistration(localDateTime);

        User user = UniversityMapper.toUserEntity(universityDTO);
        User storedUser = userRepository.saveAndFlush(user);
        Credential credential = UniversityMapper.toCredentialEntity(universityDTO);

        Optional<Role> optionalRole=roleRepository.findByName(Roles.ROLE_UNIVERSITY_ADMIN.name());
        Role role = optionalRole.orElseThrow(()-> new RoleNotAvailableException());
        credential.getRoles().add(role);
        role.getCredential().add(credential);
        credential.setUser(storedUser);
        storedUser.setCredential(credential);
        university.setUniversityAdmin(storedUser);
        storedUser.setUniversity(university);
        universityRepository.saveAndFlush(university);
    }
}
