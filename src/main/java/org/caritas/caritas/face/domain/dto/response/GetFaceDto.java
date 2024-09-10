package org.caritas.caritas.face.domain.dto.response;

import java.io.Serializable;

import org.caritas.caritas.face.domain.enumeration.Status;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetFaceDto implements Serializable {
    Long id;
    String code;
    Float total;
    Status status;
    Long projectId;
}
