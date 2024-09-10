package org.caritas.caritas.face.infrastructure.repository;

import org.caritas.caritas.face.domain.model.Face;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FaceRepository extends JpaRepository<Face, Long>, JpaSpecificationExecutor<Face> {

}
