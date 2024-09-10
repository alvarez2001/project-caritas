package org.caritas.caritas.item.domain.dto.request;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ItemSearchCriteria implements Serializable {

    String name;
    String code;
}
