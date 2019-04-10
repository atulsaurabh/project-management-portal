package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.GroupDTO;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.GroupDetails;
import org.parul.pmp.entity.Student;

public class GroupMapper {
    public static GroupDetails toEntity(GroupDTO dto)
    {
        GroupDetails gd = new GroupDetails();
        gd.setGroupName(dto.getGroupName());
        gd.setDescription(dto.getDescription());
        gd.setDateOfGroupCreation(dto.getDateOfGroupCreation());
        return gd;

    }
    public static Student toStudentEntity(GroupDTO dto)
    {
        Student student = new Student();
        return student;
    }
    public static Faculty toFacultyEntity(GroupDTO dto)
    {
        Faculty faculty = new Faculty();
        return faculty;
    }

    public static GroupDTO toDTO(GroupDetails groupDetails)
    {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setGroupId(groupDetails.getGroupId());
        groupDTO.setGroupName(groupDetails.getGroupName());
        groupDTO.setDateOfGroupCreation(groupDetails.getDateOfGroupCreation());
        return groupDTO;
    }
}
