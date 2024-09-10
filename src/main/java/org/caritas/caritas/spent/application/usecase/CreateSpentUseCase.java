package org.caritas.caritas.spent.application.usecase;

import org.caritas.caritas.face.application.usecase.FindLastActiveFaceUseCase;
import org.caritas.caritas.face.application.usecase.UpdateAmountFaceUseCase;
import org.caritas.caritas.face.domain.dto.request.UpdateAmountFaceDto;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.caritas.caritas.item.application.usecase.FindByIdItemUseCase;
import org.caritas.caritas.item.application.usecase.UpdateAmountsItemUseCase;
import org.caritas.caritas.item.domain.dto.request.UpdateAmountItemDto;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.caritas.caritas.project.application.usecase.FindByIdProjectUseCase;
import org.caritas.caritas.project.application.usecase.UpdateAmountProjectUseCase;
import org.caritas.caritas.project.domain.dto.request.UpdateAmountProjectDto;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.caritas.caritas.spent.domain.dto.request.PostSpentDto;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
import org.caritas.caritas.spent.domain.mappers.PostSpentMapper;
import org.caritas.caritas.spent.domain.mappers.SpentMapper;
import org.caritas.caritas.spent.domain.model.Spent;
import org.caritas.caritas.spent.infrastructure.repository.SpentRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateSpentUseCase {

    private final SpentRepository repository;
    private final FindLastActiveFaceUseCase findLastActiveByProjectId;
    private final FindByIdItemUseCase findByIdItemUseCase;
    private final FindByIdProjectUseCase findByIdProjectUseCase;

    private final UpdateAmountFaceUseCase updateAmountFaceUseCase;
    private final UpdateAmountsItemUseCase updateAmountsItemUseCase;
    private final UpdateAmountProjectUseCase updateAmountProjectUseCase;

    public GetSpentDto execute(PostSpentDto dto) {
        Spent entity = PostSpentMapper.execute(dto);

        GetItemDto item = findByIdItemUseCase.execute(entity.getItemId());
        GetFaceDto face = findLastActiveByProjectId.execute(item.getProjectId());
        GetProjectDto project = findByIdProjectUseCase.execute(item.getProjectId());
        Long spentCountFaceId = repository.countByFaceId(face.getId());

        entity.setFaceId(face.getId());
        entity.setCode(project.getCode() + "-" + spentCountFaceId + 1L);

        Spent entitySaved = repository.save(entity);

        UpdateAmountFaceDto updateAmountFaceDto = new UpdateAmountFaceDto();
        updateAmountFaceDto.setAmount(entity.getTotal());
        updateAmountFaceUseCase.execute(face.getId(), updateAmountFaceDto);

        UpdateAmountProjectDto updateAmountProjectDto = new UpdateAmountProjectDto();
        updateAmountProjectDto.setAmount(entity.getTotal());
        updateAmountProjectUseCase.execute(project.getId(), updateAmountProjectDto);

        UpdateAmountItemDto updateAmountItemDto = new UpdateAmountItemDto();
        updateAmountItemDto.setAmount(entity.getTotal());
        updateAmountsItemUseCase.execute(item.getId(), updateAmountItemDto);

        return SpentMapper.toGetDto(entitySaved);
    }
}
