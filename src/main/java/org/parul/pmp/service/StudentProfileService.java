package org.parul.pmp.service;

import org.parul.pmp.dto.FacultyProfileDTO;
import org.parul.pmp.dto.StudentProfileDTO;
import org.parul.pmp.dto.mapper.FacultyProfileMapper;
import org.parul.pmp.dto.mapper.StudentProfileMapper;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.Student;
import org.parul.pmp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentProfileService {
    @Autowired
    private StudentRepository studentRepository;
    public void addStudentProfile(StudentProfileDTO studentProfileDTO)
    {
        Student student = StudentProfileMapper.toEntity(studentProfileDTO);
        LocalDateTime localDateTime = LocalDateTime.now();
        student.setDateOfModification(localDateTime);
        studentRepository.saveAndFlush(student);
    }
}
