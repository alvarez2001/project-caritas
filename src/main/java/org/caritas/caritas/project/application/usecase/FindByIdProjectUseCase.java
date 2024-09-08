package org.caritas.caritas.project.application.usecase;

import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.caritas.caritas.project.domain.mappers.ProjectMapper;
import org.caritas.caritas.project.domain.model.Project;
import org.caritas.caritas.project.infrastructure.repository.ProjectRepository;
import org.caritas.caritas.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdProjectUseCase {

    private final ProjectRepository projectRepository;

    public GetProjectDto execute(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("[Project::"+id+"] NOT FOUND"));

        return ProjectMapper.toGetDto(project);
    }
}
