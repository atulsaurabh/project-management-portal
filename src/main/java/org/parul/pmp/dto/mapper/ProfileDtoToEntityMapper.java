package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.StudentProfileDTO;

import org.parul.pmp.entity.Student;

public class ProfileDtoToEntityMapper {
    public Student toEnity(StudentProfileDTO profileDTO)
    {
        Student registration = new Student();

        registration.setDob(profileDTO.getDob());
        registration.setGender(profileDTO.getGender());
        registration.setAddress(profileDTO.getAddress());


        return registration;
    }
}
