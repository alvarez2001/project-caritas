package org.caritas.caritas.item.infrastructure.controller;

import org.caritas.caritas.item.application.usecase.UpdateItemUseCase;
import org.caritas.caritas.item.domain.dto.request.UpdateItemDto;
import org.caritas.caritas.item.domain.dto.response.GetItemDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class UpdateItemController {

    @Autowired
    private UpdateItemUseCase updateUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<GetItemDto> execute(
            @Valid @RequestBody UpdateItemDto updateDto,
            @PathVariable Long id) {
        GetItemDto item = updateUseCase.execute(id, updateDto);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

}
