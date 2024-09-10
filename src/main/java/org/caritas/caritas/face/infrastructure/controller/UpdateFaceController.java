package org.caritas.caritas.face.infrastructure.controller;

import org.caritas.caritas.face.application.usecase.UpdateFaceUseCase;
import org.caritas.caritas.face.domain.dto.request.UpdateFaceDto;
import org.caritas.caritas.face.domain.dto.response.GetFaceDto;
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
@RequestMapping("/faces")
@RequiredArgsConstructor
public class UpdateFaceController {

    @Autowired
    private UpdateFaceUseCase updateUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<GetFaceDto> execute(
            @Valid @RequestBody UpdateFaceDto updateDto,
            @PathVariable Long id) {
        GetFaceDto face = updateUseCase.execute(id, updateDto);
        return ResponseEntity.status(HttpStatus.OK).body(face);
    }

}
