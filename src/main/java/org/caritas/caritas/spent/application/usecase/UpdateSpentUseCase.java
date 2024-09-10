package org.caritas.caritas.spent.application.usecase;

import org.caritas.caritas.spent.domain.dto.request.UpdateSpentDto;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
import org.caritas.caritas.spent.domain.mappers.SpentMapper;
import org.caritas.caritas.spent.domain.mappers.UpdateSpentMapper;
import org.caritas.caritas.spent.domain.model.Spent;
import org.caritas.caritas.spent.infrastructure.repository.SpentRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateSpentUseCase {

    private final SpentRepository repository;
    private final FindByIdSpentUseCase findByIdUseCase;

    public GetSpentDto execute(Long id, UpdateSpentDto updateDto) {
        GetSpentDto dto = findByIdUseCase.execute(id);

        Spent entity = UpdateSpentMapper.execute(dto, updateDto);
        Spent entitySaved = repository.save(entity);
        repository.save(entitySaved);
        return SpentMapper.toGetDto(entitySaved);
    }
}
