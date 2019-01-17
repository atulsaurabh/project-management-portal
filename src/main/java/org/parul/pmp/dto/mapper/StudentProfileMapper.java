package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.StudentProfileDTO;

import org.parul.pmp.entity.Student;

public class StudentProfileMapper {
    public static Student toEntity(StudentProfileDTO studentProfileDTO) {
        Student profile = new Student();
        profile.setDob(studentProfileDTO.getDob());
        profile.setGender(studentProfileDTO.getGender());
        return profile;
    }

}
