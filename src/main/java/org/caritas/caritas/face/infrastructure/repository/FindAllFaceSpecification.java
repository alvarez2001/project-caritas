package org.caritas.caritas.face.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.caritas.caritas.face.domain.dto.request.FaceSearchCriteria;
import org.caritas.caritas.face.domain.model.Face;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindAllFaceSpecification implements Specification<Face> {

    private FaceSearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Face> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(this.searchCriteria.getCode())) {
            Predicate nameLike = criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("code")),
                    "%" + this.searchCriteria.getCode().toLowerCase() + "%");
            predicates.add(nameLike);
        }

        if (searchCriteria.getStatus() != null) {
            Predicate statusEqual = criteriaBuilder.equal(root.get("status"), this.searchCriteria.getStatus());
            predicates.add(statusEqual);
        }


        Predicate[] predicatesAsArray = new Predicate[0];
        return criteriaBuilder.and(predicates.toArray(predicatesAsArray));
    }

}
