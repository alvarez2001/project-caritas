package org.caritas.caritas.shared.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagedResponseDto<T> {
        private List<T> content;
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;
}