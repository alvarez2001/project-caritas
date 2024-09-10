package org.caritas.caritas.item.infrastructure.controller;

import org.caritas.caritas.item.application.usecase.FindByIdItemUseCase;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class FindByIdItemController {

    @Autowired
    private FindByIdItemUseCase findByIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<GetItemDto> execute(@PathVariable Long id) {
        GetItemDto item = findByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

}
