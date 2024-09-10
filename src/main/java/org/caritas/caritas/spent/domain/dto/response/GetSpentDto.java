package org.caritas.caritas.spent.domain.dto.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetSpentDto implements Serializable {
    Long id;
    String code;
    Float amount;
    String unit;
    Float quantity;
    Float total;
    Long itemId;
    Long faceId;
}
