package org.caritas.caritas.item.application.usecase;

import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.caritas.caritas.item.domain.mappers.ItemMapper;
import org.caritas.caritas.item.domain.model.Item;
import org.caritas.caritas.item.infrastructure.repository.ItemRepository;
import org.caritas.caritas.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdItemUseCase {

    private final ItemRepository repository;

    public GetItemDto execute(Long id) {
        Item project = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("[Item::"+id+"] NOT FOUND"));

        return ItemMapper.toGetDto(project);
    }
}
