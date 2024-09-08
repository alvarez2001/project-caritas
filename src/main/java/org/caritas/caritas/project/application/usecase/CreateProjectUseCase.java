package org.caritas.caritas.project.application.usecase;

import org.caritas.caritas.project.domain.dto.request.PostProjectDto;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.caritas.caritas.project.domain.mappers.PostProjectMapper;
import org.caritas.caritas.project.domain.mappers.ProjectMapper;
import org.caritas.caritas.project.domain.model.Project;
import org.caritas.caritas.project.infrastructure.repository.ProjectRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateProjectUseCase {

    private final ProjectRepository projectRepository;

    public GetProjectDto execute(PostProjectDto projectDto) {
        Project project = PostProjectMapper.execute(projectDto);
        Project projectSaved = projectRepository.save(project);
        return ProjectMapper.toGetDto(projectSaved);
    }
}
