package org.caritas.caritas.face.domain.mappers;

import java.util.Collections;
import java.util.List;

import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.caritas.caritas.face.domain.model.Face;

public class FaceMapper {

    private FaceMapper() {
    }

    public static GetFaceDto toGetDto(Face entity) {
        if (entity == null)
            return null;

        GetFaceDto getFaceDto = new GetFaceDto();
        getFaceDto.setId(entity.getId());
        getFaceDto.setCode(entity.getCode());
        getFaceDto.setStatus(entity.getStatus());
        getFaceDto.setTotal(entity.getTotal());
        getFaceDto.setProjectId(entity.getProjectId());
        return getFaceDto;

    }

    public static List<GetFaceDto> toGetDtoList(List<Face> entity) {
        if (entity == null)
            return Collections.emptyList();

        return entity.stream().map(FaceMapper::toGetDto).toList();
    }

}
