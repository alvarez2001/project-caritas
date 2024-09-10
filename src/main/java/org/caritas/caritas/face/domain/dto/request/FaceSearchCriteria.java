package org.caritas.caritas.face.domain.dto.request;

import java.io.Serializable;

import org.caritas.caritas.face.domain.enumeration.Status;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FaceSearchCriteria implements Serializable {
    String code;
    Status status;
}
