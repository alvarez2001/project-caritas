package org.caritas.caritas.project.infrastructure.controller;

import org.caritas.caritas.project.application.usecase.UpdateProjectUseCase;
import org.caritas.caritas.project.domain.dto.request.UpdateProjectDto;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
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
@RequestMapping("/projects")
@RequiredArgsConstructor
public class UpdateProjectController {

    @Autowired
    private UpdateProjectUseCase updateProjectUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<GetProjectDto> execute(
            @Valid @RequestBody UpdateProjectDto updateProjectDto,
            @PathVariable Long id) {
        GetProjectDto project = updateProjectUseCase.execute(id, updateProjectDto);
        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

}
