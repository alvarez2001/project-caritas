package org.caritas.caritas.spent.domain.mappers;

import java.util.Collections;
import java.util.List;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
import org.caritas.caritas.spent.domain.model.Spent;

public class SpentMapper {

    private SpentMapper() {
    }

    public static GetSpentDto toGetDto(Spent entity) {
        if (entity == null)
            return null;

        GetSpentDto getSpentDto = new GetSpentDto();
        getSpentDto.setId(entity.getId());
        getSpentDto.setCode(entity.getCode());
        getSpentDto.setAmount(entity.getAmount());
        getSpentDto.setUnit(entity.getUnit());
        getSpentDto.setQuantity(entity.getQuantity());
        getSpentDto.setTotal(entity.getTotal());
        getSpentDto.setFaceId(entity.getFaceId());
        getSpentDto.setItemId(entity.getItemId());
        return getSpentDto;

    }

    public static List<GetSpentDto> toGetDtoList(List<Spent> entity) {
        if (entity == null)
            return Collections.emptyList();

        return entity.stream().map(SpentMapper::toGetDto).toList();
    }

}
