package org.caritas.caritas.face.domain.dto.request;

import java.io.Serializable;

import org.caritas.caritas.face.domain.enumeration.Status;
import org.caritas.caritas.shared.validation.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateFaceDto implements Serializable {

        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        String code;

        @NotNull
        @ValidEnum(enumClass = Status.class, message = "Estado inválido")
        Status status;
}
