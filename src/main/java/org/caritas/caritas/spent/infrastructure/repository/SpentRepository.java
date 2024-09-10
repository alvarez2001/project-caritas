package org.caritas.caritas.spent.infrastructure.repository;

import org.caritas.caritas.spent.domain.model.Spent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface SpentRepository extends JpaRepository<Spent, Long>, JpaSpecificationExecutor<Spent> {

    @Query("select count(s) from Spent s where s.faceId = ?1")
    Long countByFaceId(Long faceId);

}
