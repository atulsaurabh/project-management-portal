package org.parul.pmp.service;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.mapper.FacultyMapper;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    public void addFaculty(FacultyDTO facultyDTO)
    {
        Faculty faculty = FacultyMapper.toEntity(facultyDTO);
        LocalDateTime localDateTime = LocalDateTime.now();
        faculty.setDateOfModification(localDateTime);
        faculty.setDateOfRegistration(localDateTime);
        facultyRepository.saveAndFlush(faculty);
    }
}
