package org.caritas.caritas.face.domain.mappers;

import org.caritas.caritas.face.domain.dto.request.UpdateFaceDto;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.caritas.caritas.face.domain.model.Face;

public class UpdateFaceMapper {

    private UpdateFaceMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Face execute(GetFaceDto getDto, UpdateFaceDto updateDto) {
        if (getDto == null || updateDto == null)
            return null;

        Face entity = new Face();

        entity.setId(getDto.getId());

        entity.setCode(updateDto.getCode());
        entity.setTotal(getDto.getTotal());
        entity.setStatus(updateDto.getStatus());
        entity.setProjectId(getDto.getProjectId());

        return entity;
    }
}
