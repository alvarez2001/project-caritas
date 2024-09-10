package org.caritas.caritas.spent.domain.mappers;

import org.caritas.caritas.spent.domain.dto.request.UpdateSpentDto;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
import org.caritas.caritas.spent.domain.model.Spent;

public class UpdateSpentMapper {

    private UpdateSpentMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Spent execute(GetSpentDto getDto, UpdateSpentDto updateDto) {
        if (getDto == null || updateDto == null)
            return null;

        Spent entity = new Spent();

        entity.setId(getDto.getId());

        entity.setCode(getDto.getCode());
        entity.setAmount(getDto.getAmount());
        entity.setUnit(updateDto.getUnit());
        entity.setQuantity(getDto.getQuantity());
        entity.setTotal(getDto.getTotal());
        entity.setFaceId(getDto.getFaceId());
        entity.setItemId(getDto.getItemId());

        return entity;
    }
}
