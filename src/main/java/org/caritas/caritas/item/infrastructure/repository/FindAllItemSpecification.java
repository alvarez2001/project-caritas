package org.caritas.caritas.item.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.caritas.caritas.item.domain.dto.request.ItemSearchCriteria;
import org.caritas.caritas.item.domain.model.Item;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindAllItemSpecification implements Specification<Item> {

    private ItemSearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(this.searchCriteria.getName())) {
            Predicate nameLike = criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("name")),
                    "%" + this.searchCriteria.getName().toLowerCase() + "%");
            predicates.add(nameLike);
        }

        if (StringUtils.hasText(this.searchCriteria.getCode())) {
            Predicate codeLike = criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("code")),
                    "%" + this.searchCriteria.getCode().toLowerCase() + "%");
            predicates.add(codeLike);
        }

        Predicate[] predicatesAsArray = new Predicate[0];
        return criteriaBuilder.and(predicates.toArray(predicatesAsArray));
    }

}
