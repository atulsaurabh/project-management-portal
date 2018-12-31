package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.Role;
import org.parul.pmp.entity.User;
import org.parul.pmp.entity.enumeration.Roles;

public class FacultyMapper {
    public static Faculty toEntity(FacultyDTO dto)
    {
        Faculty register = new Faculty();
        register.setFaculty_id(dto.getFaculty_id());
        register.setFaculty_firstname(dto.getFaculty_firstname());
        register.setFaculty_middlename(dto.getFaculty_middlename());
        register.setFaculty_lastname(dto.getFaculty_lastname());
        register.setEmail(dto.getEmail());
        register.setPhone(dto.getPhone());
        User faculty = new User();
        Credential credential = new Credential();
        credential.setUsername(dto.getUsername());
        credential.setPassword(dto.getPassword());
        Role role = new Role();
        role.setName(Roles.ROLE_FACULTY.name());
        role.getCredential().add(credential);
        credential.getRoles().add(role);
        credential.setUser(faculty);
        faculty.setCredential(credential);
        return register;
    }
}
