package org.parul.pmp.dto.mapper;


import org.parul.pmp.dto.DepartmentDTO;
import org.parul.pmp.entity.Department;


public class DepartmentMapper
{
    public static Department toEntity(DepartmentDTO dto)
    {
        Department department = new Department();
        department.setDepartmentCode(dto.getDepartmentCode());
        department.setDepartment_name(dto.getDepartment_name());
        return department;
    }
    public static DepartmentDTO toDTO(Department department)
    {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentCode(department.getDepartmentCode());
        dto.setDepartment_name(department.getDepartment_name());
        dto.setDeptid(department.getDeptid());
        return dto;
    }

}
