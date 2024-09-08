package org.caritas.caritas.project.infrastructure.controller;

import org.caritas.caritas.project.application.usecase.CreateProjectUseCase;
import org.caritas.caritas.project.domain.dto.request.PostProjectDto;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
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
@RequestMapping("/projects")
@RequiredArgsConstructor
public class CreateProjectController {

    @Autowired
    private CreateProjectUseCase createProjectUseCase;

    @PostMapping
    public ResponseEntity<GetProjectDto> execute(@Valid @RequestBody PostProjectDto newProject) {
        GetProjectDto project = createProjectUseCase.execute(newProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

}
