package org.parul.pmp.service;

import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.dto.mapper.UniversityMapper;
import org.parul.pmp.entity.University;
import org.parul.pmp.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    public void addUniversity(UniversityDTO universityDTO)
    {
        University university = UniversityMapper.toEntity(universityDTO);
        LocalDateTime localDateTime = LocalDateTime.now();
        university.setDateOfModification(localDateTime);
        university.setDateOfRegistration(localDateTime);
        universityRepository.saveAndFlush(university);
    }
}
