package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.Role;
import org.parul.pmp.entity.University;
import org.parul.pmp.entity.User;
import org.parul.pmp.entity.enumeration.Roles;

import javax.persistence.Entity;

public class UniversityMapper
{
    public static University toEntity(UniversityDTO dto)
    {
        University university = new University();
        university.setContact_no(dto.getContact_no());
        university.setEmail(dto.getEmail());
        university.setFax(dto.getFax());
        university.setUniversity_name(dto.getUniversity_name());
        university.setUniversity_code(dto.getUniversity_code());
        university.setWebsite(dto.getWebsite());
        return university;
    }

    public static User toUserEntity(UniversityDTO universityDTO)
    {
        User admin = new User();
        Credential credential = new Credential();
        credential.setUsername(universityDTO.getUsername());
        credential.setPassword(universityDTO.getPassword());
        Role role = new Role();
        role.setName(Roles.ROLE_ADMIN.name());
        role.getCredential().add(credential);
        credential.getRoles().add(role);
        credential.setUser(admin);
        admin.setCredential(credential);
        return admin;
    }
}
