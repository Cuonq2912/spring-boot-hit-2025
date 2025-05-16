package org.example.btvnonline1.domain.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponseDTO {

    Long id;
    String name;
    String location;
    Double price;
    LocalDate creatDate;
    LocalDate lastModifiedDate;
}
