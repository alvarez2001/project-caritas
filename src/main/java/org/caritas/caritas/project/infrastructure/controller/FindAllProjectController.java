package org.caritas.caritas.project.infrastructure.controller;

import org.caritas.caritas.project.application.usecase.FindAllProjectUseCase;
import org.caritas.caritas.project.domain.dto.request.ProjectSearchCriteria;
import org.caritas.caritas.project.domain.dto.response.GetProjectDto;
import org.caritas.caritas.project.domain.enumeration.Status;
import org.caritas.caritas.project.domain.enumeration.TypeMoney;
import org.caritas.caritas.shared.dto.PagedResponseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class FindAllProjectController {

    @Autowired
    private FindAllProjectUseCase findAllProjectUseCase;

    @GetMapping()
    public ResponseEntity<PagedResponseDto<GetProjectDto>> execute(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) TypeMoney typeMoney,
            @RequestParam(required = false) Status status,
            Pageable pageable) {
        ProjectSearchCriteria searchCriteria = new ProjectSearchCriteria();
        searchCriteria.setName(name);
        searchCriteria.setTypeMoney(typeMoney);
        searchCriteria.setStatus(status);
        PagedResponseDto<GetProjectDto> projects = findAllProjectUseCase.execute(searchCriteria, pageable);

        return ResponseEntity.ok().body(projects);
    }

}
