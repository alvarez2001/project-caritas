package org.caritas.caritas.face.domain.mappers;

import org.caritas.caritas.face.domain.dto.request.PostFaceDto;
import org.caritas.caritas.face.domain.model.Face;

public class PostFaceMapper {

    private PostFaceMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Face execute(PostFaceDto dto) {
        if (dto == null)
            return null;

        Face entity = new Face();

        entity.setCode(dto.getCode());
        entity.setStatus(dto.getStatus());
        entity.setTotal(dto.getTotal());
        entity.setProjectId(dto.getProjectId());

        return entity;
    }
}
