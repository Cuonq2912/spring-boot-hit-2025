package org.example.test.domain.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.test.constant.ErrorMessage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCreateDto {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String name;

    String description;

    @DecimalMin(value = "0.0", inclusive = false, message = ErrorMessage.Book.INVALID_PRICE_GREATER_THAN_ZERO)
    Double price;

    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    Long authorId;

    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    Long categoryId;
}
