package org.caritas.caritas.face.infrastructure.controller;

import org.caritas.caritas.face.application.usecase.CreateFaceUseCase;
import org.caritas.caritas.face.domain.dto.request.PostFaceDto;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
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
@RequestMapping("/faces")
@RequiredArgsConstructor
public class CreateFaceController {

    @Autowired
    private CreateFaceUseCase createUseCase;

    @PostMapping
    public ResponseEntity<GetFaceDto> execute(@Valid @RequestBody PostFaceDto postDto) {
        GetFaceDto project = createUseCase.execute(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

}
