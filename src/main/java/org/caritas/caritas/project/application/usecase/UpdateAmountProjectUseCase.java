package org.caritas.caritas.project.application.usecase;

import org.caritas.caritas.project.domain.dto.request.UpdateAmountProjectDto;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.caritas.caritas.project.domain.mappers.ProjectMapper;
import org.caritas.caritas.project.domain.mappers.UpdateAmountProjectMapper;
import org.caritas.caritas.project.domain.model.Project;
import org.caritas.caritas.project.infrastructure.repository.ProjectRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateAmountProjectUseCase {

    private final ProjectRepository projectRepository;
    private final FindByIdProjectUseCase findByIdProjectUseCase;

    public GetProjectDto execute(Long id, UpdateAmountProjectDto projectDto) {
        GetProjectDto getProjectDto = findByIdProjectUseCase.execute(id);

        Project project = UpdateAmountProjectMapper.execute(getProjectDto, projectDto);
        Project projectSaved = projectRepository.save(project);
        projectRepository.save(projectSaved);
        return ProjectMapper.toGetDto(projectSaved);
    }
}
