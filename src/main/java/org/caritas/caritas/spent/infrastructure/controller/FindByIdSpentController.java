package org.caritas.caritas.spent.infrastructure.controller;

import org.caritas.caritas.spent.application.usecase.FindByIdSpentUseCase;
import org.caritas.caritas.spent.domain.dto.response.GetSpentDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/spents")
@RequiredArgsConstructor
public class FindByIdSpentController {

    @Autowired
    private FindByIdSpentUseCase findByIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<GetSpentDto> execute(@PathVariable Long id) {
        GetSpentDto spent = findByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(spent);
    }

}
