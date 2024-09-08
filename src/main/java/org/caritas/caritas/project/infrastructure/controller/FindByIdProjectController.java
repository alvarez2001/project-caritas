package org.caritas.caritas.project.infrastructure.controller;

import org.caritas.caritas.project.application.usecase.FindByIdProjectUseCase;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class FindByIdProjectController {

    @Autowired
    private FindByIdProjectUseCase findByIdProjectUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<GetProjectDto> execute(@PathVariable Long id) {
        GetProjectDto project = findByIdProjectUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

}
