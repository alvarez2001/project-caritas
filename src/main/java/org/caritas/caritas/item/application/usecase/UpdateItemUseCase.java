package org.caritas.caritas.item.application.usecase;

import org.caritas.caritas.item.domain.dto.request.UpdateItemDto;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.caritas.caritas.item.domain.mappers.ItemMapper;
import org.caritas.caritas.item.domain.mappers.UpdateItemMapper;
import org.caritas.caritas.item.domain.model.Item;
import org.caritas.caritas.item.infrastructure.repository.ItemRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateItemUseCase {

    private final ItemRepository repository;
    private final FindByIdItemUseCase findByIdUseCase;

    public GetItemDto execute(Long id, UpdateItemDto updateDto) {
        GetItemDto dto = findByIdUseCase.execute(id);

        Item entity = UpdateItemMapper.execute(dto, updateDto);
        Item entitySaved = repository.save(entity);
        repository.save(entitySaved);
        return ItemMapper.toGetDto(entitySaved);
    }
}
