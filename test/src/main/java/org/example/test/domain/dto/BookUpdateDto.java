package org.example.test.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookUpdateDto {

    String name;
    String description;
    Double price;
    Long authorId;
    Long categoryId;
}
