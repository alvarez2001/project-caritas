package org.caritas.caritas.project.domain.mappers;

import org.caritas.caritas.project.domain.dto.request.UpdateAmountProjectDto;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.caritas.caritas.project.domain.model.Project;

public class UpdateAmountProjectMapper {

    private UpdateAmountProjectMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Project execute(GetProjectDto getProjectDto, UpdateAmountProjectDto updateProjectDto) {
        if (updateProjectDto == null || getProjectDto == null)
            return null;

        Project project = new Project();

        project.setId(getProjectDto.getId());
        project.setName(getProjectDto.getName());
        project.setCode(getProjectDto.getCode());
        project.setTypeMoney(getProjectDto.getTypeMoney());
        project.setAvailable(getProjectDto.getAvailable() - updateProjectDto.getAmount());
        project.setRequest(getProjectDto.getRequest());
        project.setStatus(getProjectDto.getStatus());

        return project;
    }
}
