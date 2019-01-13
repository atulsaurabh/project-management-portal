package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.ProfileDTO;

import org.parul.pmp.entity.Student;

public class ProfileDtoToEntityMapper {
    public Student toEnity(ProfileDTO profileDTO)
    {
        Student registration = new Student();

        registration.setDob(profileDTO.getDob());
        registration.setGender(profileDTO.getGender());
        registration.setAddress(profileDTO.getAddress());


        return registration;
    }
}
