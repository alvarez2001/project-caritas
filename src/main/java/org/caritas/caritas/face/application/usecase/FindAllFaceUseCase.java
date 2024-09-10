package org.caritas.caritas.face.application.usecase;

import org.caritas.caritas.face.domain.dto.request.FaceSearchCriteria;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.caritas.caritas.face.domain.mappers.FaceMapper;
import org.caritas.caritas.face.domain.model.Face;
import org.caritas.caritas.face.infrastructure.repository.FaceRepository;
import org.caritas.caritas.face.infrastructure.repository.FindAllFaceSpecification;
import org.caritas.caritas.shared.dto.PagedResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAllFaceUseCase {

    private final FaceRepository repository;

    public PagedResponseDto<GetFaceDto> execute(FaceSearchCriteria searchCriteria, Pageable pageable) {
        FindAllFaceSpecification specification = new FindAllFaceSpecification(searchCriteria);
        Page<Face> facesPage = repository.findAll(specification, pageable);
        Page<GetFaceDto> facesDto = facesPage.map(FaceMapper::toGetDto);
        PagedResponseDto<GetFaceDto> pagedResponseDto = new PagedResponseDto<>();

        pagedResponseDto.setContent(facesDto.getContent());
        pagedResponseDto.setPage(facesDto.getNumber());
        pagedResponseDto.setSize(facesDto.getSize());
        pagedResponseDto.setTotalElements(facesDto.getTotalElements());
        pagedResponseDto.setTotalPages(facesDto.getTotalPages());
        return pagedResponseDto;
    }
}
