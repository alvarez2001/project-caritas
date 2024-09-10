package org.caritas.caritas.project.domain.dto.request;

import java.io.Serializable;

import org.caritas.caritas.project.domain.enumeration.TypeMoney;
import org.caritas.caritas.shared.validation.ValidEnum;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostProjectDto implements Serializable {
        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        String name;

        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        String code;

        @NotNull
        @ValidEnum(enumClass = TypeMoney.class, message = "Moneda inválida")
        TypeMoney typeMoney;

        @NotNull
        @DecimalMin(value = "0.01")
        Float request;
}
