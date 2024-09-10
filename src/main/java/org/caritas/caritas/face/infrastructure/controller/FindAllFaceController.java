package org.caritas.caritas.face.infrastructure.controller;

import org.caritas.caritas.face.application.usecase.FindAllFaceUseCase;
import org.caritas.caritas.face.domain.dto.request.FaceSearchCriteria;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.caritas.caritas.face.domain.enumeration.Status;
import org.caritas.caritas.shared.dto.PagedResponseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/faces")
@RequiredArgsConstructor
public class FindAllFaceController {

    @Autowired
    private FindAllFaceUseCase findAllUseCase;

    @GetMapping()
    public ResponseEntity<PagedResponseDto<GetFaceDto>> execute(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) Status status,
            Pageable pageable) {
        FaceSearchCriteria searchCriteria = new FaceSearchCriteria();
        searchCriteria.setCode(code);
        searchCriteria.setStatus(status);
        PagedResponseDto<GetFaceDto> data = findAllUseCase.execute(searchCriteria, pageable);

        return ResponseEntity.ok().body(data);
    }

}
