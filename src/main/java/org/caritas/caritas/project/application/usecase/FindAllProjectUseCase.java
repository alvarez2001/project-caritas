package org.caritas.caritas.project.application.usecase;

import org.caritas.caritas.project.domain.dto.request.ProjectSearchCriteria;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.caritas.caritas.project.domain.mappers.ProjectMapper;
import org.caritas.caritas.project.domain.model.Project;
import org.caritas.caritas.project.infrastructure.repository.FindAllProjectSpecification;
import org.caritas.caritas.project.infrastructure.repository.ProjectRepository;
import org.caritas.caritas.shared.dto.PagedResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAllProjectUseCase {

    private final ProjectRepository projectRepository;

    public PagedResponseDto<GetProjectDto> execute(ProjectSearchCriteria searchCriteria, Pageable pageable) {
        FindAllProjectSpecification specification = new FindAllProjectSpecification(searchCriteria);
        Page<Project> projectsPage = projectRepository.findAll(specification, pageable);
        Page<GetProjectDto> projectsDto = projectsPage.map(ProjectMapper::toGetDto);
        PagedResponseDto<GetProjectDto> pagedResponseDto = new PagedResponseDto<>();

        pagedResponseDto.setContent(projectsDto.getContent());
        pagedResponseDto.setPage(projectsDto.getNumber());
        pagedResponseDto.setSize(projectsDto.getSize());
        pagedResponseDto.setTotalElements(projectsDto.getTotalElements());
        pagedResponseDto.setTotalPages(projectsDto.getTotalPages());
        return pagedResponseDto;
    }
}
