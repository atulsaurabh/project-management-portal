package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.DepartmentDTO;
import org.parul.pmp.entity.Department;

public class DepartmentMapper
{
    public static DepartmentDTO toDTO(Department department)
    {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDeptid(department.getDepartment_id());
        dto.setDeptName(department.getDepartment_name());
        return dto;
    }
}
