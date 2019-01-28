package org.parul.pmp.service;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.FacultyProfileDTO;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.dto.mapper.FacultyProfileMapper;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FacultyProfileService {
    @Autowired
    private FacultyRepository facultyRepository;
    public void addFacultyProfile(FacultyProfileDTO facultyProfileDTO)
    {
        Faculty faculty = FacultyProfileMapper.toEntity(facultyProfileDTO);
        LocalDateTime localDateTime = LocalDateTime.now();
        faculty.setDateOfModification(localDateTime);
        facultyRepository.saveAndFlush(faculty);
    }
}
