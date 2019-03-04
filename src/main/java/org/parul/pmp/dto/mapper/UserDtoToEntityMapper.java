package org.parul.pmp.dto.mapper;


import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.entity.Student;

public class UserDtoToEntityMapper
{

    public Student toEnity(StudentDTO userDTO)
    {
        Student registration = new Student();
        registration.setFirstname(userDTO.getFirstname());
        registration.setMiddlename(userDTO.getMiddlename());
        registration.setLastname(userDTO.getLastname());
        registration.setEnrollmentNo(userDTO.getEnrollmentNo());
        //registration.setEnrollmentNo(userDTO.getEnrollmentNo());
        //registration.setCollege(userDTO.getCollege());
        registration.setSem(userDTO.getSem());
        //registration.setDept(userDTO.getDept());
        registration.setEmail(userDTO.getEmail());
        registration.setMobile_no(userDTO.getMobile_no());


        return registration;
    }

}
