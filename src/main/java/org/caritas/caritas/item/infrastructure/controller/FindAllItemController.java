package org.caritas.caritas.item.infrastructure.controller;

import org.caritas.caritas.item.application.usecase.FindAllItemUseCase;
import org.caritas.caritas.item.domain.dto.request.ItemSearchCriteria;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
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
@RequestMapping("/items")
@RequiredArgsConstructor
public class FindAllItemController {

    @Autowired
    private FindAllItemUseCase findAllUseCase;

    @GetMapping()
    public ResponseEntity<PagedResponseDto<GetItemDto>> execute(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            Pageable pageable) {
        ItemSearchCriteria searchCriteria = new ItemSearchCriteria();
        searchCriteria.setName(name);
        searchCriteria.setCode(code);
        PagedResponseDto<GetItemDto> data = findAllUseCase.execute(searchCriteria, pageable);

        return ResponseEntity.ok().body(data);
    }

}
