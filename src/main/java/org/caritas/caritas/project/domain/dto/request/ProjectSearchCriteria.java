package org.caritas.caritas.project.domain.dto.request;

import java.io.Serializable;

import org.caritas.caritas.project.domain.enumeration.Status;
import org.caritas.caritas.project.domain.enumeration.TypeMoney;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProjectSearchCriteria implements Serializable {

    String name;
    TypeMoney typeMoney;
    Status status;
}
