package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.CollegeDTO;
import org.parul.pmp.entity.College;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.User;

public class CollegeMapper {
    public static College toEntity(CollegeDTO dto)
    {
        College register = new College();
        register.setCollegeCode(dto.getCollege_code());
        register.setCollege_name(dto.getCollege_name());
        register.setContact_no(dto.getContact_no());
        register.setEmail(dto.getEmail());
        register.setWebsite(dto.getWebsite());
        register.setFax(dto.getFax());


        return register;
    }
    public static CollegeDTO toDTO(College college)
    {
        CollegeDTO dto = new CollegeDTO();
        dto.setCollege_code(college.getCollegeCode());
        dto.setCollege_name(college.getCollege_name());
        return dto;
    }

    public static User toUserEntity(CollegeDTO collegeDTO )
    {
        User admin = new User();
        return admin;
    }

    public static Credential toCredentialEntity(CollegeDTO collegeDTO )
    {
        Credential credential = new Credential();
        credential.setUsername(collegeDTO.getUsername());
        credential.setPassword(collegeDTO.getPassword());
        return credential;
    }
}
