package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.ProjectDTO;
import org.parul.pmp.entity.Project;

public class ProjectMapper {
    public static Project toEntity(ProjectDTO projectDTO)
    {
        Project project = new Project();
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        return project;
    }
}
