package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.University;
import org.parul.pmp.entity.User;

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
    public static UniversityDTO toDTO(University university)
    {
        UniversityDTO dto = new UniversityDTO();

        dto.setUniversity_code(university.getUniversity_code());
        dto.setUniversity_name(university.getUniversity_name());
        dto.setUniversity_id(university.getUniversity_id());
        return dto;
    }

    public static User toUserEntity(UniversityDTO universityDTO)
    {
        User admin = new User();
        return admin;
    }

    public static Credential toCredentialEntity(UniversityDTO universityDTO)
    {
        Credential credential = new Credential();
        credential.setUsername(universityDTO.getUsername());
        credential.setPassword(universityDTO.getPassword());
        return credential;
    }
}
