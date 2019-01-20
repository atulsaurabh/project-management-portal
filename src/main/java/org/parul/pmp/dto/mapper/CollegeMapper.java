package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.CollegeDTO;
import org.parul.pmp.entity.College;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.User;

public class CollegeMapper {
    public static College toEntity(CollegeDTO dto)
    {
        College college = new College();
        college.setCollege_code(dto.getCollege_code());
        college.setCollege_name(dto.getCollege_name());
        college.setContact_no(dto.getContact_no());
        college.setEmail(dto.getEmail());
        college.setWebsite(dto.getWebsite());
        college.setFax(dto.getFax());
        return college;
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
