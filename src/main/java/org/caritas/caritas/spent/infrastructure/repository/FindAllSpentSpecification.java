package org.caritas.caritas.spent.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.caritas.caritas.spent.domain.dto.request.SpentSearchCriteria;
import org.caritas.caritas.spent.domain.model.Spent;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindAllSpentSpecification implements Specification<Spent> {

    private SpentSearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Spent> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (searchCriteria.getFaceId() != null) {
            Predicate equalData = criteriaBuilder.equal(root.get("faceId"), this.searchCriteria.getFaceId());
            predicates.add(equalData);
        }

        if (searchCriteria.getItemId() != null) {
            Predicate equalData = criteriaBuilder.equal(root.get("itemId"), this.searchCriteria.getItemId());
            predicates.add(equalData);
        }

        Predicate[] predicatesAsArray = new Predicate[0];
        return criteriaBuilder.and(predicates.toArray(predicatesAsArray));
    }

}
