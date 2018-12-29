package org.parul.pmp.mapper;

import org.parul.pmp.dto.ProfileDTO;

import org.parul.pmp.entity.PmpMember;

public class ProfileDtoToEntityMapper {
    public PmpMember toEnity(ProfileDTO profileDTO)
    {
        PmpMember registration = new PmpMember();

        registration.setDob(profileDTO.getDob());
        registration.setGender(profileDTO.getGender());
        registration.setAddress(profileDTO.getAddress());
        registration.setCountry(profileDTO.getCountry());
        registration.setState(profileDTO.getState());
        registration.setCity(profileDTO.getCity());
        registration.setPincode(profileDTO.getPincode());

        return registration;
    }
}
