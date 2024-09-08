package org.caritas.caritas.project.domain.mappers;

import org.caritas.caritas.project.domain.dto.request.UpdateProjectDto;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.caritas.caritas.project.domain.model.Project;

public class UpdateProjectMapper {

    private UpdateProjectMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Project execute(GetProjectDto getProjectDto, UpdateProjectDto updateProjectDto) {
        if (updateProjectDto == null || getProjectDto == null)
            return null;

        Project project = new Project();

        project.setId(getProjectDto.getId());
        project.setName(updateProjectDto.getName());
        project.setTypeMoney(updateProjectDto.getTypeMoney());
        project.setAvailable(getProjectDto.getRequest());
        project.setRequest(getProjectDto.getRequest());
        project.setStatus(getProjectDto.getStatus());

        return project;
    }
}
