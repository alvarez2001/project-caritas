package org.caritas.caritas.face.infrastructure.controller;

import org.caritas.caritas.face.application.usecase.FindByIdFaceUseCase;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/faces")
@RequiredArgsConstructor
public class FindByIdFaceController {

    @Autowired
    private FindByIdFaceUseCase findByIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<GetFaceDto> execute(@PathVariable Long id) {
        GetFaceDto face = findByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(face);
    }

}
