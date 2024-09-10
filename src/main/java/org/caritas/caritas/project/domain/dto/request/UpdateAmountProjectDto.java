package org.caritas.caritas.project.domain.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateAmountProjectDto implements Serializable {
    @NotNull
    @DecimalMin(value = "0.01")
    Float amount;
}
