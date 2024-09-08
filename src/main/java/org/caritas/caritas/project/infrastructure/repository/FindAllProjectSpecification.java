package org.caritas.caritas.project.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.caritas.caritas.project.domain.dto.request.ProjectSearchCriteria;
import org.caritas.caritas.project.domain.model.Project;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindAllProjectSpecification implements Specification<Project> {

    private ProjectSearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(this.searchCriteria.getName())) {
            Predicate nameLike = criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("name")),
                    "%" + this.searchCriteria.getName().toLowerCase() + "%");
            predicates.add(nameLike);
        }

        if (searchCriteria.getTypeMoney() != null) {
            Predicate typeMoneyEqual = criteriaBuilder.equal(root.get("typeMoney"), this.searchCriteria.getTypeMoney());
            predicates.add(typeMoneyEqual);
        }

        if (searchCriteria.getStatus() != null) {
            Predicate statusEqual = criteriaBuilder.equal(root.get("status"), this.searchCriteria.getStatus());
            predicates.add(statusEqual);
        }

        Predicate[] predicatesAsArray = new Predicate[0];
        return criteriaBuilder.and(predicates.toArray(predicatesAsArray));
    }

}
