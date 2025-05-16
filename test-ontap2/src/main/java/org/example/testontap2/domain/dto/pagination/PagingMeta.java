package org.example.ontap2.domain.dto.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PagingMeta {

    long totalElements;
    long totalPages;
    int currentPage;
    int pageSize;
    String sortBy;
    String sortType;
}
