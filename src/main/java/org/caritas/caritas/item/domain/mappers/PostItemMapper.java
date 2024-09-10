package org.caritas.caritas.item.domain.mappers;

import org.caritas.caritas.item.domain.dto.request.PostItemDto;
import org.caritas.caritas.item.domain.model.Item;

public class PostItemMapper {

    private PostItemMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Item execute(PostItemDto dto) {
        if (dto == null)
            return null;

        Item entity = new Item();

        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setAvailable(dto.getRequest());
        entity.setRequest(dto.getRequest());
        entity.setTotal(dto.getRequest());
        entity.setProjectId(dto.getProjectId());

        return entity;
    }
}
