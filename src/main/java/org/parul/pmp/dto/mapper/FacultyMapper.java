package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.entity.*;

public class FacultyMapper {
    public static Faculty toEntity(FacultyDTO dto)
    {
        Faculty register = new Faculty();
        register.setFacultyCode(dto.getFacultyCode());
        register.setFacultyFirstname(dto.getFacultyFirstname());
        register.setFacultyMiddlename(dto.getFacultyMiddlename());
        register.setFacultyLastname(dto.getFacultyLastname());
        register.setEmail(dto.getEmail());
        register.setPhone(dto.getPhone());
        //register.setHod(true);
        return register;
    }
    public static User toUserEntity(FacultyDTO facultyDTO)
    {
        User faculty = new User();
        return faculty;
    }
    public static Credential toCredentialEntity(FacultyDTO facultyDTO)
    {
        Credential credential = new Credential();
        credential.setUsername(facultyDTO.getUsername());
        credential.setPassword(facultyDTO.getPassword());
        return credential;
    }

    public static FacultyDTO toDTO(Faculty faculty)
    {
        FacultyDTO dto = new FacultyDTO();
        dto.setFacultyCode(faculty.getFacultyCode());
        dto.setFacultyFirstname(faculty.getFacultyFirstname());
        dto.setFacultyMiddlename(faculty.getFacultyMiddlename());
        dto.setFacultyLastname(faculty.getFacultyLastname());
        dto.setHod(faculty.isHod());
        return dto;
    }
}
