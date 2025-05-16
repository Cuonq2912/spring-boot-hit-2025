package org.example.ontap2.domain.dto.reponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


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

    LocalDateTime creatDate;

    LocalDateTime lastModifiedDate;

}

