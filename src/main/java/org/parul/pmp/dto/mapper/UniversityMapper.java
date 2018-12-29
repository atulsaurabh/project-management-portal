package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.UniversityDTO;
import org.parul.pmp.entity.University;

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
}
