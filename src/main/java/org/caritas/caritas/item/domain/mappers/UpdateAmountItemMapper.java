package org.caritas.caritas.item.domain.mappers;

import org.caritas.caritas.item.domain.dto.request.UpdateAmountItemDto;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.caritas.caritas.item.domain.model.Item;

public class UpdateAmountItemMapper {

    private UpdateAmountItemMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Item execute(GetItemDto getDto, UpdateAmountItemDto updateDto) {
        if (getDto == null || updateDto == null)
            return null;

        Item entity = new Item();

        entity.setId(getDto.getId());
        entity.setCode(getDto.getCode());
        entity.setName(getDto.getName());
        entity.setAvailable(getDto.getAvailable() - updateDto.getAmount());
        entity.setRequest(getDto.getRequest());
        entity.setTotal(getDto.getTotal() - updateDto.getAmount());
        entity.setProjectId(getDto.getProjectId());

        return entity;
    }
}
