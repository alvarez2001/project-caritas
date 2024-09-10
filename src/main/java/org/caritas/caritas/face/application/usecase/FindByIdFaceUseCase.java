package org.caritas.caritas.face.application.usecase;

import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.caritas.caritas.face.domain.mappers.FaceMapper;
import org.caritas.caritas.face.domain.model.Face;
import org.caritas.caritas.face.infrastructure.repository.FaceRepository;
import org.caritas.caritas.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdFaceUseCase {

    private final FaceRepository repository;

    public GetFaceDto execute(Long id) {
        Face project = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("[Face::" + id + "] NOT FOUND"));

        return FaceMapper.toGetDto(project);
    }
}
