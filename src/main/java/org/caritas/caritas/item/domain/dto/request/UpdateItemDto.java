package org.caritas.caritas.item.domain.dto.request;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateItemDto implements Serializable {
        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        String code;

        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        String name;
}
