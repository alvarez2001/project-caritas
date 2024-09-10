package org.caritas.caritas.spent.domain.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateSpentDto implements Serializable {

        @NotNull
        @NotEmpty
        String unit;
}
