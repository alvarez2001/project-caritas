package org.caritas.caritas.spent.application.usecase;

import org.caritas.caritas.shared.exception.ResourceNotFoundException;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
import org.caritas.caritas.spent.domain.mappers.SpentMapper;
import org.caritas.caritas.spent.domain.model.Spent;
import org.caritas.caritas.spent.infrastructure.repository.SpentRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdSpentUseCase {

    private final SpentRepository repository;

    public GetSpentDto execute(Long id) {
        Spent project = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("[Spent::" + id + "] NOT FOUND"));

        return SpentMapper.toGetDto(project);
    }
}
