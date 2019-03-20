package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.StudentDTO;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.Student;
import org.parul.pmp.entity.User;

public class StudentMapper
{

    public static Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstname(studentDTO.getFirstname());
        student.setMiddlename(studentDTO.getMiddlename());
        student.setLastname(studentDTO.getLastname());
        student.setEnrollment(studentDTO.getEnrollment());
        student.setSem(studentDTO.getSem());
        student.setEmail(studentDTO.getEmail());
        student.setMobile_no(studentDTO.getMobile_no());
        student.setGroupMember(true);
        return student;
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
    public static StudentDTO toDTO(Student student)
    {
        StudentDTO dto = new StudentDTO();
        dto.setEnrollment(student.getEnrollment());
        dto.setFirstname(student.getFirstname());
        dto.setLastname(student.getLastname());
        dto.setEmail(student.getEmail());
        dto.setEnrollment(student.getEnrollment());
        return dto;
    }

}
