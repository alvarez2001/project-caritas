package org.caritas.caritas.item.infrastructure.controller;

import org.caritas.caritas.item.application.usecase.CreateItemUseCase;
import org.caritas.caritas.item.domain.dto.request.PostItemDto;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class CreateItemController {

    @Autowired
    private CreateItemUseCase createUseCase;

    @PostMapping
    public ResponseEntity<GetItemDto> execute(@Valid @RequestBody PostItemDto postDto) {
        GetItemDto project = createUseCase.execute(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

}
