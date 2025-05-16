package org.example.btvnonline1.domain.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonResponseDTO {
    Boolean status;
    String message;
}
