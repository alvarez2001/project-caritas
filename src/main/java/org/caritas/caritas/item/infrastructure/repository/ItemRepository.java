package org.caritas.caritas.item.infrastructure.repository;

import org.caritas.caritas.item.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

}
