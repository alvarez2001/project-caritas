package org.caritas.caritas.item.application.usecase;

import org.caritas.caritas.item.domain.dto.request.ItemSearchCriteria;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.caritas.caritas.item.domain.mappers.ItemMapper;
import org.caritas.caritas.item.domain.model.Item;
import org.caritas.caritas.item.infrastructure.repository.FindAllItemSpecification;
import org.caritas.caritas.item.infrastructure.repository.ItemRepository;
import org.caritas.caritas.shared.dto.PagedResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAllItemUseCase {

    private final ItemRepository repository;

    public PagedResponseDto<GetItemDto> execute(ItemSearchCriteria searchCriteria, Pageable pageable) {
        FindAllItemSpecification specification = new FindAllItemSpecification(searchCriteria);
        Page<Item> itemsPage = repository.findAll(specification, pageable);
        Page<GetItemDto> itemsDto = itemsPage.map(ItemMapper::toGetDto);
        PagedResponseDto<GetItemDto> pagedResponseDto = new PagedResponseDto<>();

        pagedResponseDto.setContent(itemsDto.getContent());
        pagedResponseDto.setPage(itemsDto.getNumber());
        pagedResponseDto.setSize(itemsDto.getSize());
        pagedResponseDto.setTotalElements(itemsDto.getTotalElements());
        pagedResponseDto.setTotalPages(itemsDto.getTotalPages());
        return pagedResponseDto;
    }
}
