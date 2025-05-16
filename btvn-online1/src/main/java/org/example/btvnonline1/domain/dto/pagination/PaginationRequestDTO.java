package org.example.btvnonline1.domain.dto.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaginationRequestDTO {

    int pageNum;
    int pageSize;
}
