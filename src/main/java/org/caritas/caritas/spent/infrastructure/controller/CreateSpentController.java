package org.caritas.caritas.spent.infrastructure.controller;

import org.caritas.caritas.spent.application.usecase.CreateSpentUseCase;
import org.caritas.caritas.spent.domain.dto.request.PostSpentDto;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
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
@RequestMapping("/spents")
@RequiredArgsConstructor
public class CreateSpentController {

    @Autowired
    private CreateSpentUseCase createUseCase;

    @PostMapping
    public ResponseEntity<GetSpentDto> execute(@Valid @RequestBody PostSpentDto postDto) {
        GetSpentDto project = createUseCase.execute(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

}
