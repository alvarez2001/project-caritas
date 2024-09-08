package org.caritas.caritas.project.domain.mappers;

import java.util.Collections;
import java.util.List;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.caritas.caritas.project.domain.model.Project;

public class ProjectMapper {

    private ProjectMapper() {
    }

    public static GetProjectDto toGetDto(Project project) {
        if (project == null)
            return null;

        GetProjectDto getProjectDto = new GetProjectDto();
        getProjectDto.setId(project.getId());
        getProjectDto.setName(project.getName());
        getProjectDto.setTypeMoney(project.getTypeMoney());
        getProjectDto.setAvailable(project.getAvailable());
        getProjectDto.setRequest(project.getRequest());
        getProjectDto.setStatus(project.getStatus());
        return getProjectDto;

    }

    public static List<GetProjectDto> toGetDtoList(List<Project> projects) {
        if (projects == null)
            return Collections.emptyList();

        return projects.stream().map(ProjectMapper::toGetDto).toList();
    }

}
