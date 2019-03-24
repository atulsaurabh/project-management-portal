package org.parul.pmp.service;

import org.parul.pmp.dto.ProjectDTO;
import org.parul.pmp.dto.mapper.ProjectMapper;
import org.parul.pmp.entity.Project;
import org.parul.pmp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository ;
    public void addProject(ProjectDTO projectDTO)
    {
        Project project = ProjectMapper.toEntity(projectDTO);
        LocalDateTime localDateTime = LocalDateTime.now();
        project.setDateOfRegistration(localDateTime);
        project.setDateOfModification(localDateTime);
        projectRepository.saveAndFlush(project);
    }
}
