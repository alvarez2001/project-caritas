package org.caritas.caritas.spent.domain.dto.request;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SpentSearchCriteria implements Serializable {
    Long itemId;
    Long faceId;
}
