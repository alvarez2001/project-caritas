package org.caritas.caritas.item.domain.mappers;

import org.caritas.caritas.item.domain.dto.request.UpdateItemDto;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.caritas.caritas.item.domain.model.Item;

public class UpdateItemMapper {

    private UpdateItemMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Item execute(GetItemDto getDto, UpdateItemDto updateDto) {
        if (getDto == null || updateDto == null)
            return null;

        Item entity = new Item();

        entity.setId(getDto.getId());
        entity.setCode(updateDto.getCode());
        entity.setName(updateDto.getName());
        entity.setAvailable(getDto.getAvailable());
        entity.setRequest(getDto.getRequest());
        entity.setTotal(getDto.getTotal());
        entity.setProjectId(getDto.getProjectId());

        return entity;
    }
}
