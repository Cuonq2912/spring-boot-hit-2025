package org.example.test.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.test.constant.ErrorMessage;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorCreateDto {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String name;
    LocalDateTime dateOfBirth;
    String bio;

}
