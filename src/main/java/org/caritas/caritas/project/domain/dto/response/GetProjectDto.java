package org.caritas.caritas.project.domain.dto.response;

import java.io.Serializable;

import org.caritas.caritas.project.domain.enumeration.Status;
import org.caritas.caritas.project.domain.enumeration.TypeMoney;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetProjectDto implements Serializable {
    Long id;
    String name;
    TypeMoney typeMoney;
    Float available;
    Float request;
    Status status;
}
