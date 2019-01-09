package org.parul.pmp.service;

import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.dto.mapper.UniversityMapper;
import org.parul.pmp.entity.University;
import org.parul.pmp.entity.User;
import org.parul.pmp.repository.UniversityRepository;
import org.parul.pmp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private UserRepository userRepository;
    public void addUniversity(UniversityDTO universityDTO)
    {
        University university = UniversityMapper.toEntity(universityDTO);
        LocalDateTime localDateTime = LocalDateTime.now();
        university.setDateOfModification(localDateTime);
        university.setDateOfRegistration(localDateTime);

        User user = UniversityMapper.toUserEntity(universityDTO);
        User storedUser = userRepository.saveAndFlush(user);
        university.setUniversityAdmin(storedUser);
        storedUser.setUniversity(university);
        universityRepository.saveAndFlush(university);
    }
}
