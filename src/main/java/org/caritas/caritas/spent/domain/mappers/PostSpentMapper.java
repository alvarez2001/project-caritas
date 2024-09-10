package org.caritas.caritas.spent.domain.mappers;

import org.caritas.caritas.spent.domain.dto.request.PostSpentDto;
import org.caritas.caritas.spent.domain.model.Spent;

public class PostSpentMapper {

    private PostSpentMapper() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
    }

    public static Spent execute(PostSpentDto dto) {
        if (dto == null)
            return null;

        Spent entity = new Spent();

        entity.setAmount(dto.getAmount());
        entity.setUnit(dto.getUnit());
        entity.setQuantity(dto.getQuantity());
        entity.setTotal(dto.getAmount() * dto.getQuantity());
        entity.setItemId(dto.getItemId());
        
        entity.setCode(null);
        entity.setFaceId(null);

        return entity;
    }
}
