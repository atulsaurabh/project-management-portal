package org.parul.pmp.dto.mapper;



import org.parul.pmp.dto.UserDTO;
import org.parul.pmp.entity.Student;

public class UserDtoToEntityMapper
{

    public Student toEnity(UserDTO userDTO)
    {
        Student registration = new Student();
        registration.setFirstname(userDTO.getFirstname());
        registration.setMiddlename(userDTO.getMiddlename());
        registration.setLastname(userDTO.getLastname());
        registration.setEnrollment_no(userDTO.getEnrollment_no());
        registration.setCollege(userDTO.getCollege());
        registration.setSem(userDTO.getSem());
        registration.setDept(userDTO.getDept());
        registration.setEmail(userDTO.getEmail());
        registration.setMobile_no(userDTO.getMobile_no());


        return registration;
    }

}
