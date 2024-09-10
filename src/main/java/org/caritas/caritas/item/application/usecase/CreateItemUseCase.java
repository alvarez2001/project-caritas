package org.caritas.caritas.item.application.usecase;

import org.caritas.caritas.item.domain.dto.request.PostItemDto;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.caritas.caritas.item.domain.mappers.ItemMapper;
import org.caritas.caritas.item.domain.mappers.PostItemMapper;
import org.caritas.caritas.item.domain.model.Item;
import org.caritas.caritas.item.infrastructure.repository.ItemRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateItemUseCase {

    private final ItemRepository repository;

    public GetItemDto execute(PostItemDto dto) {
        Item entity = PostItemMapper.execute(dto);
        Item entitySaved = repository.save(entity);
        return ItemMapper.toGetDto(entitySaved);
    }
}
