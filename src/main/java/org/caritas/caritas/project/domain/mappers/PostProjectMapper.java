package org.caritas.caritas.project.domain.mappers;

import org.caritas.caritas.project.domain.dto.request.PostProjectDto;
import org.caritas.caritas.project.domain.enumeration.Status;
import org.caritas.caritas.project.domain.model.Project;

public class PostProjectMapper {

    private PostProjectMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Project execute(PostProjectDto postProjectDto) {
        if (postProjectDto == null)
            return null;

        Project project = new Project();

        project.setName(postProjectDto.getName());
        project.setCode(postProjectDto.getCode());
        project.setTypeMoney(postProjectDto.getTypeMoney());
        project.setAvailable(postProjectDto.getRequest());
        project.setRequest(postProjectDto.getRequest());
        project.setStatus(Status.ACTIVE);

        return project;
    }
}
