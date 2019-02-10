package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.entity.*;
import org.parul.pmp.entity.enumeration.Roles;

public class FacultyMapper {
    public static Faculty toEntity(FacultyDTO dto)
    {
        Faculty register = new Faculty();
        register.setFaculty_code(dto.getFaculty_code());
        register.setFaculty_firstname(dto.getFaculty_firstname());
        register.setFaculty_middlename(dto.getFaculty_middlename());
        register.setFaculty_lastname(dto.getFaculty_lastname());
        register.setEmail(dto.getEmail());
        register.setPhone(dto.getPhone());
        register.setHod(true);
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

}
