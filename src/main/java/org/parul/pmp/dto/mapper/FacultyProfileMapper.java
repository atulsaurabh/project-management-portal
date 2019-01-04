package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.FacultyProfileDTO;
import org.parul.pmp.entity.Faculty;

public class FacultyProfileMapper {
    public static Faculty toEntity(FacultyProfileDTO facultyProfileDTO){
        Faculty profile=new Faculty();
        profile.setEducation(facultyProfileDTO.getEducation());
        profile.setSkill(facultyProfileDTO.getSkill());
        profile.setPublished_papers(facultyProfileDTO.getPublished_papers());
        profile.setAddress(facultyProfileDTO.getAddress());
        return profile;
    }
}
