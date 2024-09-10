package org.caritas.caritas.item.domain.dto.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetItemDto implements Serializable {
    Long id;
    String code;
    String name;
    Float available;
    Float request;
    Float total;
    Long projectId;
}
