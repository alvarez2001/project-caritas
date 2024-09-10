package org.caritas.caritas.item.domain.dto.request;

import java.io.Serializable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostItemDto implements Serializable {

        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        String code;

        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        String name;

        @NotNull
        @DecimalMin(value = "0.01")
        Float request;

        @NotNull
        @Positive
        Long projectId;
}
