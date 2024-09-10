package org.caritas.caritas.item.infrastructure.repository;

import java.util.List;

import org.caritas.caritas.item.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    @Query("select i from Item i where i.projectId = ?1")
    List<Item> findByProjectId(Long projectId);

}
