package org.example.btvnonline1.domain.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.btvnonline1.domain.dto.pagination.PaginationRequestDTO;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelSearchRequestDTO extends PaginationRequestDTO {

    String name;
    String location;
    Double price;

    public HotelSearchRequestDTO(int pageNum, int pageSize) {
        super(pageNum, pageSize);
    }
}
