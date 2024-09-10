package org.caritas.caritas.face.domain.mappers;

import org.caritas.caritas.face.domain.dto.request.UpdateAmountFaceDto;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.caritas.caritas.face.domain.model.Face;

public class UpdateAmountFaceMapper {

    private UpdateAmountFaceMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Face execute(GetFaceDto getDto, UpdateAmountFaceDto updateDto) {
        if (getDto == null || updateDto == null)
            return null;

        Face entity = new Face();

        entity.setId(getDto.getId());

        entity.setCode(getDto.getCode());
        entity.setTotal(getDto.getTotal() + updateDto.getAmount());
        entity.setStatus(getDto.getStatus());
        entity.setProjectId(getDto.getProjectId());

        return entity;
    }
}
