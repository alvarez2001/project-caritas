package org.caritas.caritas.spent.infrastructure.controller;

import org.caritas.caritas.spent.application.usecase.UpdateSpentUseCase;
import org.caritas.caritas.spent.domain.dto.request.UpdateSpentDto;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
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
@RequestMapping("/spents")
@RequiredArgsConstructor
public class UpdateSpentController {

    @Autowired
    private UpdateSpentUseCase updateUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<GetSpentDto> execute(
            @Valid @RequestBody UpdateSpentDto updateDto,
            @PathVariable Long id) {
        GetSpentDto spent = updateUseCase.execute(id, updateDto);
        return ResponseEntity.status(HttpStatus.OK).body(spent);
    }

}
