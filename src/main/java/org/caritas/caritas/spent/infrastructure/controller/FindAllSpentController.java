package org.caritas.caritas.spent.infrastructure.controller;

import org.caritas.caritas.shared.dto.PagedResponseDto;
import org.caritas.caritas.spent.application.usecase.FindAllSpentUseCase;
import org.caritas.caritas.spent.domain.dto.request.SpentSearchCriteria;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/spents")
@RequiredArgsConstructor
public class FindAllSpentController {

    @Autowired
    private FindAllSpentUseCase findAllUseCase;

    @GetMapping()
    public ResponseEntity<PagedResponseDto<GetSpentDto>> execute(
            @RequestParam(required = false) Long faceId,
            @RequestParam(required = false) Long itemId,
            Pageable pageable) {
        SpentSearchCriteria searchCriteria = new SpentSearchCriteria();
        searchCriteria.setFaceId(faceId);
        searchCriteria.setItemId(itemId);
        PagedResponseDto<GetSpentDto> data = findAllUseCase.execute(searchCriteria, pageable);

        return ResponseEntity.ok().body(data);
    }

}
