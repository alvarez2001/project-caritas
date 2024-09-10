package org.caritas.caritas.spent.domain.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostSpentDto implements Serializable {

        @NotNull
        @DecimalMin(value = "0.01")
        Float amount;

        @NotNull
        @NotBlank
        String unit;

        @NotNull
        @DecimalMin(value = "0.01")
        Float quantity;

        @NotNull
        @Positive
        Long itemId;
}
