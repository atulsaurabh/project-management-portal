package org.parul.pmp.mapper;



import org.parul.pmp.dto.UserDTO;
import org.parul.pmp.entity.PmpMember;

public class UserDtoToEntityMapper
{

    public PmpMember toEnity(UserDTO userDTO)
    {
        PmpMember registration = new PmpMember();
        registration.setFirstname(userDTO.getFirstname());
        registration.setMiddlename(userDTO.getMiddlename());
        registration.setLastname(userDTO.getLastname());
        registration.setEnrollment_no(userDTO.getEnrollment_no());
        registration.setCollege(userDTO.getCollege());
        registration.setSem(userDTO.getSem());
        registration.setDept(userDTO.getDept());
        registration.setEmail(userDTO.getEmail());
        registration.setMobile_no(userDTO.getMobile_no());
        registration.setPassword(userDTO.getPassword());
        registration.setConfirm_password(userDTO.getConfirm_password());


        return registration;
    }

}
