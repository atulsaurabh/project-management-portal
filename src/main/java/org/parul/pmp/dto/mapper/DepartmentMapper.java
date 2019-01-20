package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.CollegeDTO;
import org.parul.pmp.dto.DepartmentDTO;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.User;

public class DepartmentMapper
{
    public static Department toEntity(DepartmentDTO dto)
    {
        Department department = new Department();
        department.setDepartment_code(dto.getDepartment_code());
        department.setDepartment_name(dto.getDepartment_name());
        return department;
    }
    public static DepartmentDTO toDTO(Department department)
    {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartment_code(department.getDepartment_code());
        dto.setDepartment_name(department.getDepartment_name());
        dto.setDeptid(department.getDepartment_id());
        return dto;
    }

}
