package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.entity.Faculty;

public class FaculyMapper {
    public static Faculty toEntity(FacultyDTO dto)
    {
        Faculty faculty = new Faculty();
        faculty.setFaculty_name(dto.getFaculty_name());
        faculty.setEmail(dto.getEmail());
        faculty.setPhone(dto.getPhone());
        return faculty;
    }
}
