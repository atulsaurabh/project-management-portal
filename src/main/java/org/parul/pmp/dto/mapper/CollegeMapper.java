package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.CollegeDTO;
import org.parul.pmp.entity.College;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.User;

public class CollegeMapper {
    public static College toEntity(CollegeDTO dto)
    {
        College register = new College();
        register.setCollege_code(dto.getCollege_code());
        register.setCollege_name(dto.getCollege_name());
        register.setContact_no(dto.getContact_no());
        register.setEmail(dto.getEmail());

        return register;
    }
    public static User toUserEntity(CollegeDTO collegeDTO)
    {
        User college = new User();
        return college;
    }
    public static Credential toCredentialEntity(CollegeDTO collegeDTO)
    {
        Credential credential = new Credential();
        credential.setUsername(collegeDTO.getUsername());
        credential.setPassword(collegeDTO.getPassword());
        return credential;
    }

}
