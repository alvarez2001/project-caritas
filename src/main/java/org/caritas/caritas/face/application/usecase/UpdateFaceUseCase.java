package org.caritas.caritas.face.application.usecase;

import org.caritas.caritas.face.domain.dto.request.UpdateFaceDto;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.caritas.caritas.face.domain.mappers.FaceMapper;
import org.caritas.caritas.face.domain.mappers.UpdateFaceMapper;
import org.caritas.caritas.face.domain.model.Face;
import org.caritas.caritas.face.infrastructure.repository.FaceRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateFaceUseCase {

    private final FaceRepository repository;
    private final FindByIdFaceUseCase findByIdUseCase;

    public GetFaceDto execute(Long id, UpdateFaceDto updateDto) {
        GetFaceDto dto = findByIdUseCase.execute(id);

        Face entity = UpdateFaceMapper.execute(dto, updateDto);
        Face entitySaved = repository.save(entity);
        repository.save(entitySaved);
        return FaceMapper.toGetDto(entitySaved);
    }
}
