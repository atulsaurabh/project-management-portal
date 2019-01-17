package org.parul.pmp.dto.mapper;



import org.parul.pmp.dto.FacultyDTO;
import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.Student;
import org.parul.pmp.entity.User;

public class StudentMapper
{

    public static Student toEntity(StudentDTO studentDTO) {
        Student registration = new Student();
        registration.setFirstname(studentDTO.getFirstname());
        registration.setMiddlename(studentDTO.getMiddlename());
        registration.setLastname(studentDTO.getLastname());
        registration.setEnrollment_no(studentDTO.getEnrollment_no());
        registration.setSem(studentDTO.getSem());
        registration.setEmail(studentDTO.getEmail());
        registration.setMobile_no(studentDTO.getMobile_no());
        return registration;
    }

    public static User toUserEntity(StudentDTO studentDTO)
    {
        User student = new User();
        return student;
    }
    public static Credential toCredentialEntity(StudentDTO studentDTO)
    {
        Credential credential = new Credential();
        credential.setUsername(studentDTO.getUsername());
        credential.setPassword(studentDTO.getPassword());
        return credential;
    }

}
