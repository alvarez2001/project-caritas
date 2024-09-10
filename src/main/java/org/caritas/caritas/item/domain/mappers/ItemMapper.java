package org.caritas.caritas.item.domain.mappers;

import java.util.Collections;
import java.util.List;

import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.caritas.caritas.item.domain.model.Item;

public class ItemMapper {

    private ItemMapper() {
    }

    public static GetItemDto toGetDto(Item entity) {
        if (entity == null)
            return null;

        GetItemDto getItemDto = new GetItemDto();
        getItemDto.setId(entity.getId());
        getItemDto.setCode(entity.getCode());
        getItemDto.setName(entity.getName());
        getItemDto.setAvailable(entity.getAvailable());
        getItemDto.setRequest(entity.getRequest());
        getItemDto.setTotal(entity.getTotal());
        getItemDto.setProjectId(entity.getProjectId());
        return getItemDto;

    }

    public static List<GetItemDto> toGetDtoList(List<Item> entity) {
        if (entity == null)
            return Collections.emptyList();

        return entity.stream().map(ItemMapper::toGetDto).toList();
    }

}
