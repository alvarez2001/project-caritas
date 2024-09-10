package org.caritas.caritas.item.application.usecase;

import java.util.List;

import org.caritas.caritas.item.domain.dto.request.PostItemDto;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.caritas.caritas.item.domain.exception.ExceedsProjectRequestException;
import org.caritas.caritas.item.domain.mappers.ItemMapper;
import org.caritas.caritas.item.domain.mappers.PostItemMapper;
import org.caritas.caritas.item.domain.model.Item;
import org.caritas.caritas.item.infrastructure.repository.ItemRepository;
import org.caritas.caritas.project.application.usecase.FindByIdProjectUseCase;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateItemUseCase {

    private final ItemRepository repository;
    private final FindByIdProjectUseCase findByIdProjectUseCase;

    public GetItemDto execute(PostItemDto dto) {
        Item entity = PostItemMapper.execute(dto);
        List<Item> items = repository.findByProjectId(dto.getProjectId());
        Float totalRequest = 0F;

        for (Item item : items) {
            totalRequest += item.getTotal();
        }

        totalRequest = totalRequest + entity.getRequest();

        GetProjectDto project = findByIdProjectUseCase.execute(dto.getProjectId());

        if (totalRequest > project.getRequest()) {
            throw new ExceedsProjectRequestException("[Project::" + dto.getProjectId() + "] EXCEEDS");
        }

        Item entitySaved = repository.save(entity);
        return ItemMapper.toGetDto(entitySaved);
    }
}
