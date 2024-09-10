package org.caritas.caritas.face.application.usecase;

import org.caritas.caritas.face.domain.dto.request.PostFaceDto;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.caritas.caritas.face.domain.mappers.FaceMapper;
import org.caritas.caritas.face.domain.mappers.PostFaceMapper;
import org.caritas.caritas.face.domain.model.Face;
import org.caritas.caritas.face.infrastructure.repository.FaceRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateFaceUseCase {

    private final FaceRepository repository;

    public GetFaceDto execute(PostFaceDto dto) {
        Face entity = PostFaceMapper.execute(dto);
        Face entitySaved = repository.save(entity);
        return FaceMapper.toGetDto(entitySaved);
    }
}
