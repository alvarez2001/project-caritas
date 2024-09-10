package org.caritas.caritas.spent.application.usecase;

import org.caritas.caritas.shared.dto.PagedResponseDto;
import org.caritas.caritas.spent.domain.dto.request.SpentSearchCriteria;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
import org.caritas.caritas.spent.domain.mappers.SpentMapper;
import org.caritas.caritas.spent.domain.model.Spent;
import org.caritas.caritas.spent.infrastructure.repository.FindAllSpentSpecification;
import org.caritas.caritas.spent.infrastructure.repository.SpentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAllSpentUseCase {

    private final SpentRepository repository;

    public PagedResponseDto<GetSpentDto> execute(SpentSearchCriteria searchCriteria, Pageable pageable) {
        FindAllSpentSpecification specification = new FindAllSpentSpecification(searchCriteria);
        Page<Spent> spentsPage = repository.findAll(specification, pageable);
        Page<GetSpentDto> spentsDto = spentsPage.map(SpentMapper::toGetDto);
        PagedResponseDto<GetSpentDto> pagedResponseDto = new PagedResponseDto<>();

        pagedResponseDto.setContent(spentsDto.getContent());
        pagedResponseDto.setPage(spentsDto.getNumber());
        pagedResponseDto.setSize(spentsDto.getSize());
        pagedResponseDto.setTotalElements(spentsDto.getTotalElements());
        pagedResponseDto.setTotalPages(spentsDto.getTotalPages());
        return pagedResponseDto;
    }
}
