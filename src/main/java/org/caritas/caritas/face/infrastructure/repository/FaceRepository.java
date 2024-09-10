package org.caritas.caritas.face.infrastructure.repository;

import java.util.Optional;

import org.caritas.caritas.face.domain.model.Face;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface FaceRepository extends JpaRepository<Face, Long>, JpaSpecificationExecutor<Face> {

    @Query("select f from Face f where f.projectId = ?1 and f.status = 'ACTIVE' order by f.createdAt desc")
    Optional<Face> findLastActiveByProjectId(Long projectId);
}
